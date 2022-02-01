package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.qqmail.b.ai;
import com.tencent.mm.plugin.qqmail.b.aj;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.w.a;
import com.tencent.mm.plugin.qqmail.b.w.c;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  implements com.tencent.mm.al.g
{
  int mode;
  private TextView uND;
  private ImageView uNE;
  ComposeUI uOZ;
  ViewGroup uPa;
  Map<String, aj> uPb;
  Map<String, v> uPc;
  Map<String, String> uPd;
  Map<String, String> uPe;
  b uPf;
  private View.OnClickListener uPg;
  
  private b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123021);
    this.uPb = new HashMap();
    this.uPc = new HashMap();
    this.uPd = new LinkedHashMap();
    this.uPe = new LinkedHashMap();
    this.uPf = null;
    this.uPg = null;
    this.mode = 5;
    this.uOZ = paramComposeUI;
    this.uPa = paramViewGroup;
    this.uPg = null;
    this.uND = paramTextView;
    this.uNE = paramImageView;
    deE();
    com.tencent.mm.kernel.g.afA().gcy.a(484, this);
    AppMethodBeat.o(123021);
  }
  
  public b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup, byte paramByte)
  {
    this(paramComposeUI, paramTextView, paramImageView, paramViewGroup);
  }
  
  public final boolean Cq(String paramString)
  {
    AppMethodBeat.i(123024);
    boolean bool = this.uPb.containsKey(paramString);
    AppMethodBeat.o(123024);
    return bool;
  }
  
  final void a(final aj paramaj)
  {
    AppMethodBeat.i(123025);
    final LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)View.inflate(this.uOZ, 2131495156, null)).findViewById(2131303313);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131303312);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131303314);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131303316);
    ProgressBar localProgressBar = (ProgressBar)localLinearLayout.findViewById(2131303317);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(2131303318);
    final ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131303315);
    ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(2131303311);
    ((ViewGroup)localLinearLayout.getParent()).removeView(localLinearLayout);
    localImageView1.setImageResource(FileExplorerUI.aCv(paramaj.name));
    localTextView1.setText(paramaj.name);
    localTextView2.setText(bt.mK(paramaj.size));
    a locala = new a((byte)0);
    locala.kXS = localImageView1;
    locala.imt = localTextView1;
    locala.uOJ = localTextView2;
    locala.uPp = localProgressBar;
    locala.uPq = localTextView3;
    locala.uPr = localImageView2;
    locala.uPs = localImageView3;
    localLinearLayout.setTag(locala);
    localLinearLayout.setId(Math.abs(paramaj.path.hashCode() / 2));
    if (this.uPg != null) {
      localLinearLayout.setOnClickListener(this.uPg);
    }
    this.uPa.addView(localLinearLayout);
    deE();
    localLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123008);
        if (localImageView2.getVisibility() == 0) {
          localImageView2.performClick();
        }
        AppMethodBeat.o(123008);
      }
    });
    localImageView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123009);
        long l;
        if (b.this.mode == 5)
        {
          l = b.this.ale(paramaj.path);
          paramaj.uMU = l;
          AppMethodBeat.o(123009);
          return;
        }
        if (b.this.mode == 6)
        {
          l = b.this.hZ(paramaj.path, paramaj.name);
          paramaj.uMU = l;
        }
        AppMethodBeat.o(123009);
      }
    });
    localImageView3.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123011);
        com.tencent.mm.ui.base.h.a(b.this.uOZ, 2131761951, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(123010);
            aj localaj;
            if ((b.3.this.uPj.state == 0) || (b.3.this.uPj.state == 1))
            {
              paramAnonymous2DialogInterface = b.this;
              localaj = b.3.this.uPj;
              if (paramAnonymous2DialogInterface.mode != 5) {
                break label216;
              }
              ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().cancel(localaj.uMU);
            }
            for (;;)
            {
              b.this.uPb.remove(b.3.this.uPj.path);
              b.this.uPc.remove(b.3.this.uPj.path);
              b.this.uPd.remove(b.3.this.uPj.path);
              b.this.uPe.remove(b.3.this.uPj.path);
              b.this.uPa.removeView(b.3.this.uPk);
              b.this.deE();
              AppMethodBeat.o(123010);
              return;
              label216:
              if (paramAnonymous2DialogInterface.mode == 6)
              {
                v localv = (v)paramAnonymous2DialogInterface.uPc.get(localaj.path);
                if (localv != null) {
                  com.tencent.mm.kernel.g.afA().gcy.a(localv);
                }
                paramAnonymous2DialogInterface.uPd.remove(localaj.path);
                paramAnonymous2DialogInterface.uPe.remove(localaj.path);
              }
            }
          }
        }, null);
        AppMethodBeat.o(123011);
      }
    });
    this.uPa.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123012);
        b.this.b(paramaj);
        AppMethodBeat.o(123012);
      }
    });
    if (paramaj.state == 0)
    {
      if (this.mode == 5)
      {
        paramaj.uMU = ale(paramaj.path);
        AppMethodBeat.o(123025);
        return;
      }
      if (this.mode == 6) {
        paramaj.uMU = hZ(paramaj.path, paramaj.name);
      }
    }
    AppMethodBeat.o(123025);
  }
  
  final long ale(final String paramString)
  {
    AppMethodBeat.i(123029);
    w.c localc = new w.c();
    localc.uMh = false;
    localc.uMg = true;
    long l = ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().a("/cgi-bin/uploaddata", "UploadFile", paramString, localc, new w.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(123016);
        b.a(b.this);
        AppMethodBeat.o(123016);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(123015);
        ad.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        paramAnonymousString = (aj)b.this.uPb.get(paramString);
        if (paramAnonymousString != null)
        {
          paramAnonymousString.state = 3;
          b.this.b(paramAnonymousString);
        }
        if (paramAnonymousInt == -5)
        {
          b.this.uOZ.uNK.a(new c.a()
          {
            public final void deh() {}
            
            public final void dei() {}
          });
          AppMethodBeat.o(123015);
          return;
        }
        AppMethodBeat.o(123015);
      }
      
      public final boolean onReady()
      {
        AppMethodBeat.i(123013);
        aj localaj = (aj)b.this.uPb.get(paramString);
        if (localaj != null)
        {
          localaj.state = 1;
          b.this.b(localaj);
        }
        AppMethodBeat.o(123013);
        return true;
      }
      
      public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(123014);
        paramAnonymousString = (String)paramAnonymousMap.get(".Response.result.DataID");
        paramAnonymousMap = (aj)b.this.uPb.get(paramString);
        if (paramAnonymousMap != null)
        {
          paramAnonymousMap.state = 2;
          paramAnonymousMap.stn = paramAnonymousString;
          b.this.b(paramAnonymousMap);
        }
        AppMethodBeat.o(123014);
      }
    });
    AppMethodBeat.o(123029);
    return l;
  }
  
  final void b(aj paramaj)
  {
    AppMethodBeat.i(123034);
    int i = Math.abs(paramaj.path.hashCode() / 2);
    Object localObject = (LinearLayout)this.uPa.findViewById(i);
    if (localObject == null)
    {
      AppMethodBeat.o(123034);
      return;
    }
    localObject = (a)((LinearLayout)localObject).getTag();
    switch (paramaj.state)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).imt.setTextColor(this.uOZ.getResources().getColor(2131100711));
      ((a)localObject).uPp.setVisibility(0);
      ((a)localObject).uPq.setVisibility(8);
      ((a)localObject).uPr.setVisibility(8);
      ((a)localObject).uPs.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).imt.setTextColor(this.uOZ.getResources().getColor(2131100711));
      ((a)localObject).uPp.setVisibility(8);
      ((a)localObject).uPq.setVisibility(8);
      ((a)localObject).uPr.setVisibility(8);
      ((a)localObject).uPs.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).imt.setTextColor(a.n(this.uOZ, 2131100544));
      ((a)localObject).uPp.setVisibility(8);
      ((a)localObject).uPq.setVisibility(0);
      ((a)localObject).uPr.setVisibility(0);
      ((a)localObject).uPs.setVisibility(0);
    }
  }
  
  public final String deA()
  {
    AppMethodBeat.i(123026);
    String str1 = "";
    Iterator localIterator = this.uPb.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str2 = str1;
      if (str1.length() > 0) {
        str2 = str1 + "|";
      }
      str1 = str2 + ((aj)this.uPb.get(str3)).stn;
    }
    AppMethodBeat.o(123026);
    return str1;
  }
  
  public final LinkedList<aj> deB()
  {
    AppMethodBeat.i(123027);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.uPb.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.uPb.get(str));
    }
    AppMethodBeat.o(123027);
    return localLinkedList;
  }
  
  public final void deC()
  {
    AppMethodBeat.i(123028);
    Iterator localIterator;
    Object localObject;
    if (this.mode == 5)
    {
      localIterator = this.uPb.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (aj)this.uPb.get(localObject);
        if (((aj)localObject).state != 2)
        {
          ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().cancel(((aj)localObject).uMU);
          ((aj)localObject).state = 3;
          b((aj)localObject);
        }
      }
      AppMethodBeat.o(123028);
      return;
    }
    if (this.mode == 6)
    {
      localIterator = this.uPb.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (aj)this.uPb.get(localObject);
        if (((aj)localObject).state != 2)
        {
          v localv = (v)this.uPc.get(((aj)localObject).path);
          if (localv != null)
          {
            com.tencent.mm.kernel.g.afA().gcy.a(localv);
            ((aj)localObject).state = 3;
            b((aj)localObject);
          }
          this.uPd.remove(((aj)localObject).path);
          this.uPe.remove(((aj)localObject).path);
          this.uPc.remove(((aj)localObject).path);
        }
      }
    }
    AppMethodBeat.o(123028);
  }
  
  public final boolean deD()
  {
    AppMethodBeat.i(123031);
    Iterator localIterator = this.uPb.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aj)this.uPb.get(localObject);
      if ((((aj)localObject).state != 2) && (((aj)localObject).state != 3))
      {
        AppMethodBeat.o(123031);
        return false;
      }
    }
    AppMethodBeat.o(123031);
    return true;
  }
  
  public final void deE()
  {
    AppMethodBeat.i(123032);
    int j;
    int i;
    if (this.uPb.size() == 0)
    {
      this.uND.setText(this.uOZ.getString(2131761958) + " " + this.uOZ.getString(2131761961));
      this.uNE.setImageResource(2131691058);
      ((View)this.uPa.getParent()).setVisibility(8);
      j = this.uPa.getChildCount();
      i = 0;
      label102:
      if (i >= j) {
        break label311;
      }
      if (j != 1) {
        break label245;
      }
      this.uPa.getChildAt(i).setBackgroundResource(2131233185);
    }
    for (;;)
    {
      i += 1;
      break label102;
      this.uND.setText(this.uOZ.getString(2131761958) + this.uOZ.getResources().getQuantityString(2131623962, this.uPb.size(), new Object[] { Integer.valueOf(this.uPb.size()), bt.mK(getTotalSize()) }));
      this.uNE.setImageResource(2131691059);
      ((View)this.uPa.getParent()).setVisibility(0);
      break;
      label245:
      if (i == 0) {
        this.uPa.getChildAt(i).setBackgroundResource(2131233186);
      } else if ((i > 0) && (i < j - 1)) {
        this.uPa.getChildAt(i).setBackgroundResource(2131233187);
      } else {
        this.uPa.getChildAt(i).setBackgroundResource(2131233188);
      }
    }
    label311:
    AppMethodBeat.o(123032);
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(123033);
    Iterator localIterator = this.uPb.keySet().iterator();
    String str;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(((aj)this.uPb.get(str)).size + l))
    {
      str = (String)localIterator.next();
      l = i;
    }
    AppMethodBeat.o(123033);
    return i;
  }
  
  public final void hY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123023);
    if ((paramString1 == null) || (paramString1.length() == 0) || (this.uPb.containsKey(paramString1)))
    {
      AppMethodBeat.o(123023);
      return;
    }
    e locale = new e(paramString1);
    if ((!locale.exists()) || (!locale.isFile()))
    {
      AppMethodBeat.o(123023);
      return;
    }
    aj localaj = new aj();
    localaj.path = paramString1;
    if (paramString2 == null) {}
    for (localaj.name = locale.getName();; localaj.name = paramString2)
    {
      localaj.size = locale.length();
      localaj.state = 0;
      this.uPb.put(paramString1, localaj);
      a(localaj);
      AppMethodBeat.o(123023);
      return;
    }
  }
  
  final long hZ(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123030);
    if (this.uPc.containsKey(paramString1))
    {
      l = ((v)this.uPc.get(paramString1)).hashCode();
      AppMethodBeat.o(123030);
      return l;
    }
    paramString2 = new v(paramString1, paramString1, new com.tencent.mm.al.h()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final n paramAnonymousn)
      {
        AppMethodBeat.i(123019);
        ad.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 < paramAnonymousInt2)
        {
          ad.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", new Object[] { paramString1, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousn = (aj)b.this.uPb.get(paramString1);
          if (paramAnonymousn != null)
          {
            paramAnonymousn.state = 1;
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123017);
                b.this.b(paramAnonymousn);
                AppMethodBeat.o(123017);
              }
            });
          }
          AppMethodBeat.o(123019);
          return;
        }
        if (paramAnonymousInt1 >= paramAnonymousInt2)
        {
          final aj localaj = (aj)b.this.uPb.get(paramString1);
          paramAnonymousn = ((v)paramAnonymousn).deb().uKY;
          b.this.uPd.put(paramString1, paramAnonymousn);
          b.this.uPe.put(paramString1, paramString2);
          b.this.uPc.remove(paramString1);
          ad.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", new Object[] { paramString1, paramAnonymousn });
          if (localaj != null)
          {
            localaj.state = 2;
            localaj.stn = paramAnonymousn;
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123018);
                b.this.b(localaj);
                AppMethodBeat.o(123018);
              }
            });
          }
          b.a(b.this);
        }
        AppMethodBeat.o(123019);
      }
    });
    aj localaj = (aj)this.uPb.get(paramString1);
    if (localaj != null) {
      localaj.state = 1;
    }
    b(localaj);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString2, 0);
    this.uPc.put(paramString1, paramString2);
    long l = paramString2.hashCode();
    AppMethodBeat.o(123030);
    return l;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(123035);
    if (paramn.getType() == 484)
    {
      paramString = (v)paramn;
      paramn = paramString.filePath;
      final aj localaj = (aj)this.uPb.get(paramn);
      if ((localaj != null) && ((paramInt1 != 0) || (paramInt2 != 0)))
      {
        ad.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
        localaj.state = 3;
        this.uPc.remove(paramn);
        com.tencent.mm.kernel.g.afA().gcy.a(paramString);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123020);
            b.this.b(localaj);
            AppMethodBeat.o(123020);
          }
        });
      }
    }
    AppMethodBeat.o(123035);
  }
  
  final class a
  {
    TextView imt;
    ImageView kXS;
    TextView uOJ;
    ProgressBar uPp;
    TextView uPq;
    ImageView uPr;
    ImageView uPs;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void dev();
    
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b
 * JD-Core Version:    0.7.0.1
 */