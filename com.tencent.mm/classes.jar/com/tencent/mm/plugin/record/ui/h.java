package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.record.ui.viewWrappers.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class h
  extends BaseAdapter
{
  private Runnable AfR = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(27870);
      Log.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
      h.this.notifyDataSetChanged();
      AppMethodBeat.o(27870);
    }
  };
  protected a NBA;
  public int NBB = 0;
  protected List<arf> NBa = new LinkedList();
  i NBi;
  public String NBq = "";
  public String NBr = "";
  public int NBs = -1;
  public String NBt = "";
  protected MMHandler NBu = null;
  SparseArray<b> NBv = new SparseArray();
  boolean NBw = false;
  boolean NBx = false;
  private boolean NBy = false;
  protected a NBz;
  protected Context context;
  ListView mListView;
  private int padding = com.tencent.mm.cd.a.fromDPToPix(this.context, 35);
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.NBu = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(27869);
        if (paramAnonymousMessage.what == 1)
        {
          Log.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
          h.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(27869);
      }
    };
    this.NBA = parama;
  }
  
  private static void aSJ(String paramString)
  {
    if (!ab.IR(paramString))
    {
      j localj = new j();
      localj.username = paramString;
      q.bFE().b(localj);
    }
  }
  
  private arf ags(int paramInt)
  {
    if (this.NBa == null) {}
    while ((paramInt < 0) || (paramInt >= this.NBa.size())) {
      return null;
    }
    return (arf)this.NBa.get(paramInt);
  }
  
  private static int o(arf paramarf)
  {
    switch (paramarf.dataType)
    {
    default: 
      return 3;
    case 2: 
      return 1;
    case 1: 
      return 0;
    }
    return 2;
  }
  
  protected com.tencent.mm.plugin.record.ui.viewWrappers.a a(com.tencent.mm.plugin.record.ui.viewWrappers.a parama)
  {
    return parama;
  }
  
  public abstract void a(a parama);
  
  public abstract void d(com.tencent.mm.plugin.record.ui.a.b paramb);
  
  public final void destroy()
  {
    int i = 0;
    while (i < this.NBv.size())
    {
      b localb = (b)this.NBv.valueAt(i);
      if (localb != null) {
        localb.destroy();
      }
      i += 1;
    }
    if (this.NBA != null)
    {
      this.NBA.gGl();
      this.NBA = null;
    }
  }
  
  public final void gGs()
  {
    this.NBv.put(0, new d(this.context));
    Object localObject = new com.tencent.mm.plugin.record.ui.viewWrappers.a(this.NBA, this.mListView);
    ((com.tencent.mm.plugin.record.ui.viewWrappers.a)localObject).NBs = this.NBs;
    this.NBv.put(1, a((com.tencent.mm.plugin.record.ui.viewWrappers.a)localObject));
    this.NBv.put(2, new com.tencent.mm.plugin.record.ui.viewWrappers.e());
    localObject = new com.tencent.mm.plugin.record.ui.viewWrappers.b(this.NBA, this.NBu);
    ((com.tencent.mm.plugin.record.ui.viewWrappers.b)localObject).NBq = this.NBq;
    ((com.tencent.mm.plugin.record.ui.viewWrappers.b)localObject).NBr = this.NBr;
    ((com.tencent.mm.plugin.record.ui.viewWrappers.b)localObject).NBs = this.NBs;
    ((com.tencent.mm.plugin.record.ui.viewWrappers.b)localObject).NCM = this.NBt;
    ((com.tencent.mm.plugin.record.ui.viewWrappers.b)localObject).fromScene = getFromScene();
    this.NBv.put(3, localObject);
    this.NBv.put(4, new com.tencent.mm.plugin.record.ui.viewWrappers.c(this.NBA));
  }
  
  protected final void gGt()
  {
    this.NBu.post(this.AfR);
  }
  
  public int getCount()
  {
    if (this.NBa == null) {
      return 0;
    }
    return this.NBa.size();
  }
  
  protected abstract int getFromScene();
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return o(ags(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    arf localarf = ags(paramInt);
    Object localObject1 = (b)this.NBv.get(o(localarf));
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((b)localObject1).createView(this.context);
    }
    ImageView localImageView;
    Object localObject3;
    Object localObject4;
    label235:
    String[] arrayOfString;
    switch (localarf.dataType)
    {
    default: 
      paramView = new com.tencent.mm.plugin.record.ui.a.b();
      paramView.hIy = localarf;
      paramView.NBq = this.NBq;
      paramView.NCx = this.NBr;
      d(paramView);
      ((b)localObject1).a(paramViewGroup, paramInt, paramView, this.NBi);
      localImageView = (ImageView)paramViewGroup.findViewById(R.h.fUr);
      localObject3 = (TextView)paramViewGroup.findViewById(R.h.fUv);
      localObject1 = localarf.ZzA;
      paramView = (View)localObject1;
      if (localarf.Zzy != null)
      {
        localObject4 = localarf.Zzy.ZAf;
        if (!((arh)localObject4).ZAU) {
          break;
        }
        localObject4 = aa.IE(((arh)localObject4).ZAT);
        paramView = (View)localObject1;
        if (!Util.isNullOrNil((String)localObject4)) {
          paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
        }
      }
      paramView = p.b(((TextView)localObject3).getContext(), paramView, ((TextView)localObject3).getTextSize());
      if (Util.isNullOrNil(localarf.ZzZ))
      {
        ((TextView)localObject3).setText(paramView);
        localObject3 = (TextView)paramViewGroup.findViewById(R.h.fUu);
        Log.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[] { localarf.ZzC });
        if (localarf.ZzC != null)
        {
          if (!this.NBw) {
            break label710;
          }
          localObject4 = localarf.ZzC;
          arrayOfString = localarf.ZzC.split(" ");
          if (arrayOfString.length >= 2) {
            break label613;
          }
          ((TextView)localObject3).setText(localarf.ZzC);
        }
        label352:
        if (paramInt != 0) {
          break label1149;
        }
        if (localarf.Zzy == null) {
          break label1114;
        }
        paramView = localarf.Zzy.ZAf;
        localImageView.setVisibility(0);
        if (!paramView.ZAU) {
          break label981;
        }
        aSJ(paramView.ZAT);
        if (!com.tencent.mm.an.a.e.Na(paramView.ZAT)) {
          break label924;
        }
        r.bKe().loadImage(com.tencent.mm.an.a.e.Nd(paramView.ZAT), localImageView);
      }
      break;
    }
    for (;;)
    {
      if (paramInt != getCount() - 1) {
        break label1529;
      }
      paramViewGroup.findViewById(R.h.fUt).setVisibility(8);
      return paramViewGroup;
      paramView = new com.tencent.mm.plugin.record.ui.a.a();
      break;
      paramView = new com.tencent.mm.plugin.record.ui.a.c();
      break;
      paramView = (View)localObject1;
      if (!((arh)localObject4).ZAQ) {
        break label235;
      }
      localObject4 = aa.IE(((arh)localObject4).hQQ);
      paramView = (View)localObject1;
      if (Util.isNullOrNil((String)localObject4)) {
        break label235;
      }
      paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
      break label235;
      localObject1 = localarf.ZzZ;
      if (localObject1 == null) {}
      for (;;)
      {
        ((TextView)localObject3).setText(paramView);
        break;
        paramView = new SpannableStringBuilder(paramView);
        int i = paramView.length();
        paramView.append((CharSequence)localObject1);
        int j = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(c.b.open_im_display_name_color)), i, j, 33);
      }
      label613:
      paramView = arrayOfString[0];
      long l;
      try
      {
        l = new SimpleDateFormat("yyyy-MM-dd").parse(paramView).getTime();
        localObject1 = (String)DateFormat.format(this.context.getString(R.l.fmt_longdate), l);
        paramView = (View)localObject1;
      }
      catch (ParseException localParseException1)
      {
        label660:
        break label660;
      }
      ((TextView)localObject3).setText(paramView + " " + ((String)localObject4).substring(arrayOfString[0].length() + 1));
      break label352;
      label710:
      if (this.NBx)
      {
        localObject4 = localarf.ZzC;
        arrayOfString = localarf.ZzC.split(" ");
        if (arrayOfString.length < 2)
        {
          ((TextView)localObject3).setText(localarf.ZzC);
          break label352;
        }
        paramView = arrayOfString[0].substring(arrayOfString[0].indexOf("-") + 1);
        try
        {
          l = new SimpleDateFormat("MM-dd").parse(paramView).getTime();
          String str = (String)DateFormat.format(this.context.getString(R.l.fmt_date), l);
          paramView = str;
        }
        catch (ParseException localParseException2)
        {
          break label819;
        }
        ((TextView)localObject3).setText(paramView + " " + ((String)localObject4).substring(arrayOfString[0].length() + 1));
        break label352;
      }
      label819:
      paramView = localarf.ZzC.split(" ");
      if (paramView.length < 2)
      {
        ((TextView)localObject3).setText(localarf.ZzC);
        break label352;
      }
      ((TextView)localObject3).setText(localarf.ZzC.substring(paramView[0].length() + 1));
      break label352;
      label924:
      label1325:
      if ((au.bwO(paramView.ZAT)) && (localarf.ZAc) && (!Util.isNullOrNil(localarf.ZAb)))
      {
        r.bKe().loadImage(localarf.ZAb, localImageView);
      }
      else
      {
        a.b.g(localImageView, paramView.ZAT);
        continue;
        label981:
        label1114:
        label1378:
        label1387:
        if ((paramView.ZAQ) && ((!z.bAM().equals(paramView.hQQ)) || (!paramView.hQQ.equals(paramView.toUser))))
        {
          if ((au.bwO(paramView.hQQ)) && (localarf.ZAc) && (!Util.isNullOrNil(localarf.ZAb)))
          {
            r.bKe().loadImage(localarf.ZAb, localImageView);
          }
          else
          {
            aSJ(paramView.hQQ);
            a.b.g(localImageView, paramView.hQQ);
          }
        }
        else
        {
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.NBy = true;
          continue;
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.NBy = true;
          continue;
          label1149:
          if ((paramInt > 0) && (!this.NBy))
          {
            paramView = "";
            Object localObject2 = localarf.Zzy.ZAf;
            if (ags(paramInt - 1).Zzy.ZAf.ZAU) {
              paramView = ags(paramInt - 1).Zzy.ZAf.ZAT;
            }
            for (;;)
            {
              localImageView.setVisibility(0);
              if (!localarf.Zzy.ZAf.ZAU) {
                break label1387;
              }
              localObject3 = localarf.Zzy.ZAf.ZAT;
              if (paramView.equals(localObject3)) {
                break label1378;
              }
              aSJ((String)localObject3);
              if (!com.tencent.mm.an.a.e.Na(((arh)localObject2).ZAT)) {
                break label1325;
              }
              r.bKe().loadImage(com.tencent.mm.an.a.e.Nd(((arh)localObject2).ZAT), localImageView);
              break;
              if (ags(paramInt - 1).Zzy.ZAf.ZAQ) {
                paramView = ags(paramInt - 1).Zzy.ZAf.hQQ;
              }
            }
            if ((au.bwO((String)localObject3)) && (localarf.ZAc) && (!Util.isNullOrNil(localarf.ZAb)))
            {
              r.bKe().loadImage(localarf.ZAb, localImageView);
            }
            else
            {
              a.b.g(localImageView, (String)localObject3);
              continue;
              localImageView.setVisibility(4);
              continue;
              if (localarf.Zzy.ZAf.ZAQ)
              {
                localObject2 = localarf.Zzy.ZAf.hQQ;
                if (!paramView.equals(localObject2))
                {
                  if ((au.bwO((String)localObject2)) && (localarf.ZAc) && (!Util.isNullOrNil(localarf.ZAb)))
                  {
                    r.bKe().loadImage(localarf.ZAb, localImageView);
                  }
                  else
                  {
                    aSJ((String)localObject2);
                    a.b.g(localImageView, (String)localObject2);
                  }
                }
                else {
                  localImageView.setVisibility(4);
                }
              }
              else
              {
                localImageView.setVisibility(4);
              }
            }
          }
          else
          {
            localImageView.setVisibility(8);
            paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          }
        }
      }
    }
    label1529:
    paramViewGroup.findViewById(R.h.fUt).setVisibility(0);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap a(b paramb);
    
    public abstract Bitmap a(c paramc);
    
    public abstract void a(a parama);
    
    public abstract void gGl();
    
    public static final class a
    {
      public long NBD;
      public int hIA;
      public arf hIy;
      public ImageView hIz;
      public int height;
      public int width;
    }
    
    public static final class b
    {
      public long NBD;
      public boolean hIB;
      public boolean hIC;
      public arf hIy;
      public int maxWidth;
    }
    
    public static final class c
    {
      public long NBD;
      public arf hIy;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject);
    
    public abstract View createView(Context paramContext);
    
    public abstract void destroy();
    
    public abstract void pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.h
 * JD-Core Version:    0.7.0.1
 */