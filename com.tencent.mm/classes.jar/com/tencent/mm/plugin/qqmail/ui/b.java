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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.qqmail.b.ai;
import com.tencent.mm.plugin.qqmail.b.aj;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.w.a;
import com.tencent.mm.plugin.qqmail.b.w.c;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  implements com.tencent.mm.ak.g
{
  int mode;
  private TextView vWt;
  private ImageView vWu;
  ComposeUI vXP;
  ViewGroup vXQ;
  Map<String, aj> vXR;
  Map<String, v> vXS;
  Map<String, String> vXT;
  Map<String, String> vXU;
  b vXV;
  private View.OnClickListener vXW;
  
  private b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123021);
    this.vXR = new HashMap();
    this.vXS = new HashMap();
    this.vXT = new LinkedHashMap();
    this.vXU = new LinkedHashMap();
    this.vXV = null;
    this.vXW = null;
    this.mode = 5;
    this.vXP = paramComposeUI;
    this.vXQ = paramViewGroup;
    this.vXW = null;
    this.vWt = paramTextView;
    this.vWu = paramImageView;
    dsm();
    com.tencent.mm.kernel.g.agQ().ghe.a(484, this);
    AppMethodBeat.o(123021);
  }
  
  public b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup, byte paramByte)
  {
    this(paramComposeUI, paramTextView, paramImageView, paramViewGroup);
  }
  
  public final boolean Gt(String paramString)
  {
    AppMethodBeat.i(123024);
    boolean bool = this.vXR.containsKey(paramString);
    AppMethodBeat.o(123024);
    return bool;
  }
  
  final void a(final aj paramaj)
  {
    AppMethodBeat.i(123025);
    final LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)View.inflate(this.vXP, 2131495156, null)).findViewById(2131303313);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131303312);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131303314);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131303316);
    ProgressBar localProgressBar = (ProgressBar)localLinearLayout.findViewById(2131303317);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(2131303318);
    final ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131303315);
    ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(2131303311);
    ((ViewGroup)localLinearLayout.getParent()).removeView(localLinearLayout);
    localImageView1.setImageResource(FileExplorerUI.aHN(paramaj.name));
    localTextView1.setText(paramaj.name);
    localTextView2.setText(bs.qz(paramaj.size));
    a locala = new a((byte)0);
    locala.lzC = localImageView1;
    locala.iMz = localTextView1;
    locala.vXz = localTextView2;
    locala.vYf = localProgressBar;
    locala.vYg = localTextView3;
    locala.vYh = localImageView2;
    locala.vYi = localImageView3;
    localLinearLayout.setTag(locala);
    localLinearLayout.setId(Math.abs(paramaj.path.hashCode() / 2));
    if (this.vXW != null) {
      localLinearLayout.setOnClickListener(this.vXW);
    }
    this.vXQ.addView(localLinearLayout);
    dsm();
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
          l = b.this.aqd(paramaj.path);
          paramaj.vVK = l;
          AppMethodBeat.o(123009);
          return;
        }
        if (b.this.mode == 6)
        {
          l = b.this.is(paramaj.path, paramaj.name);
          paramaj.vVK = l;
        }
        AppMethodBeat.o(123009);
      }
    });
    localImageView3.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123011);
        com.tencent.mm.ui.base.h.a(b.this.vXP, 2131761951, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(123010);
            aj localaj;
            if ((b.3.this.vXZ.state == 0) || (b.3.this.vXZ.state == 1))
            {
              paramAnonymous2DialogInterface = b.this;
              localaj = b.3.this.vXZ;
              if (paramAnonymous2DialogInterface.mode != 5) {
                break label216;
              }
              ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().cancel(localaj.vVK);
            }
            for (;;)
            {
              b.this.vXR.remove(b.3.this.vXZ.path);
              b.this.vXS.remove(b.3.this.vXZ.path);
              b.this.vXT.remove(b.3.this.vXZ.path);
              b.this.vXU.remove(b.3.this.vXZ.path);
              b.this.vXQ.removeView(b.3.this.vYa);
              b.this.dsm();
              AppMethodBeat.o(123010);
              return;
              label216:
              if (paramAnonymous2DialogInterface.mode == 6)
              {
                v localv = (v)paramAnonymous2DialogInterface.vXS.get(localaj.path);
                if (localv != null) {
                  com.tencent.mm.kernel.g.agQ().ghe.a(localv);
                }
                paramAnonymous2DialogInterface.vXT.remove(localaj.path);
                paramAnonymous2DialogInterface.vXU.remove(localaj.path);
              }
            }
          }
        }, null);
        AppMethodBeat.o(123011);
      }
    });
    this.vXQ.post(new Runnable()
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
        paramaj.vVK = aqd(paramaj.path);
        AppMethodBeat.o(123025);
        return;
      }
      if (this.mode == 6) {
        paramaj.vVK = is(paramaj.path, paramaj.name);
      }
    }
    AppMethodBeat.o(123025);
  }
  
  final long aqd(final String paramString)
  {
    AppMethodBeat.i(123029);
    w.c localc = new w.c();
    localc.vUX = false;
    localc.vUW = true;
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
        ac.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        paramAnonymousString = (aj)b.this.vXR.get(paramString);
        if (paramAnonymousString != null)
        {
          paramAnonymousString.state = 3;
          b.this.b(paramAnonymousString);
        }
        if (paramAnonymousInt == -5)
        {
          b.this.vXP.vWA.a(new c.a()
          {
            public final void drP() {}
            
            public final void drQ() {}
          });
          AppMethodBeat.o(123015);
          return;
        }
        AppMethodBeat.o(123015);
      }
      
      public final boolean onReady()
      {
        AppMethodBeat.i(123013);
        aj localaj = (aj)b.this.vXR.get(paramString);
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
        paramAnonymousMap = (aj)b.this.vXR.get(paramString);
        if (paramAnonymousMap != null)
        {
          paramAnonymousMap.state = 2;
          paramAnonymousMap.tBd = paramAnonymousString;
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
    Object localObject = (LinearLayout)this.vXQ.findViewById(i);
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
      ((a)localObject).iMz.setTextColor(this.vXP.getResources().getColor(2131100711));
      ((a)localObject).vYf.setVisibility(0);
      ((a)localObject).vYg.setVisibility(8);
      ((a)localObject).vYh.setVisibility(8);
      ((a)localObject).vYi.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).iMz.setTextColor(this.vXP.getResources().getColor(2131100711));
      ((a)localObject).vYf.setVisibility(8);
      ((a)localObject).vYg.setVisibility(8);
      ((a)localObject).vYh.setVisibility(8);
      ((a)localObject).vYi.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).iMz.setTextColor(a.n(this.vXP, 2131100544));
      ((a)localObject).vYf.setVisibility(8);
      ((a)localObject).vYg.setVisibility(0);
      ((a)localObject).vYh.setVisibility(0);
      ((a)localObject).vYi.setVisibility(0);
    }
  }
  
  public final String dsi()
  {
    AppMethodBeat.i(123026);
    String str1 = "";
    Iterator localIterator = this.vXR.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str2 = str1;
      if (str1.length() > 0) {
        str2 = str1 + "|";
      }
      str1 = str2 + ((aj)this.vXR.get(str3)).tBd;
    }
    AppMethodBeat.o(123026);
    return str1;
  }
  
  public final LinkedList<aj> dsj()
  {
    AppMethodBeat.i(123027);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.vXR.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.vXR.get(str));
    }
    AppMethodBeat.o(123027);
    return localLinkedList;
  }
  
  public final void dsk()
  {
    AppMethodBeat.i(123028);
    Iterator localIterator;
    Object localObject;
    if (this.mode == 5)
    {
      localIterator = this.vXR.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (aj)this.vXR.get(localObject);
        if (((aj)localObject).state != 2)
        {
          ((o)com.tencent.mm.kernel.g.ad(o.class)).getNormalMailAppService().cancel(((aj)localObject).vVK);
          ((aj)localObject).state = 3;
          b((aj)localObject);
        }
      }
      AppMethodBeat.o(123028);
      return;
    }
    if (this.mode == 6)
    {
      localIterator = this.vXR.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (aj)this.vXR.get(localObject);
        if (((aj)localObject).state != 2)
        {
          v localv = (v)this.vXS.get(((aj)localObject).path);
          if (localv != null)
          {
            com.tencent.mm.kernel.g.agQ().ghe.a(localv);
            ((aj)localObject).state = 3;
            b((aj)localObject);
          }
          this.vXT.remove(((aj)localObject).path);
          this.vXU.remove(((aj)localObject).path);
          this.vXS.remove(((aj)localObject).path);
        }
      }
    }
    AppMethodBeat.o(123028);
  }
  
  public final boolean dsl()
  {
    AppMethodBeat.i(123031);
    Iterator localIterator = this.vXR.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aj)this.vXR.get(localObject);
      if ((((aj)localObject).state != 2) && (((aj)localObject).state != 3))
      {
        AppMethodBeat.o(123031);
        return false;
      }
    }
    AppMethodBeat.o(123031);
    return true;
  }
  
  public final void dsm()
  {
    AppMethodBeat.i(123032);
    int j;
    int i;
    if (this.vXR.size() == 0)
    {
      this.vWt.setText(this.vXP.getString(2131761958) + " " + this.vXP.getString(2131761961));
      this.vWu.setImageResource(2131691058);
      ((View)this.vXQ.getParent()).setVisibility(8);
      j = this.vXQ.getChildCount();
      i = 0;
      label102:
      if (i >= j) {
        break label311;
      }
      if (j != 1) {
        break label245;
      }
      this.vXQ.getChildAt(i).setBackgroundResource(2131233185);
    }
    for (;;)
    {
      i += 1;
      break label102;
      this.vWt.setText(this.vXP.getString(2131761958) + this.vXP.getResources().getQuantityString(2131623962, this.vXR.size(), new Object[] { Integer.valueOf(this.vXR.size()), bs.qz(getTotalSize()) }));
      this.vWu.setImageResource(2131691059);
      ((View)this.vXQ.getParent()).setVisibility(0);
      break;
      label245:
      if (i == 0) {
        this.vXQ.getChildAt(i).setBackgroundResource(2131233186);
      } else if ((i > 0) && (i < j - 1)) {
        this.vXQ.getChildAt(i).setBackgroundResource(2131233187);
      } else {
        this.vXQ.getChildAt(i).setBackgroundResource(2131233188);
      }
    }
    label311:
    AppMethodBeat.o(123032);
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(123033);
    Iterator localIterator = this.vXR.keySet().iterator();
    String str;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(((aj)this.vXR.get(str)).size + l))
    {
      str = (String)localIterator.next();
      l = i;
    }
    AppMethodBeat.o(123033);
    return i;
  }
  
  public final void ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123023);
    if ((paramString1 == null) || (paramString1.length() == 0) || (this.vXR.containsKey(paramString1)))
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
      this.vXR.put(paramString1, localaj);
      a(localaj);
      AppMethodBeat.o(123023);
      return;
    }
  }
  
  final long is(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123030);
    if (this.vXS.containsKey(paramString1))
    {
      l = ((v)this.vXS.get(paramString1)).hashCode();
      AppMethodBeat.o(123030);
      return l;
    }
    paramString2 = new v(paramString1, paramString1, new com.tencent.mm.ak.h()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final n paramAnonymousn)
      {
        AppMethodBeat.i(123019);
        ac.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 < paramAnonymousInt2)
        {
          ac.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", new Object[] { paramString1, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousn = (aj)b.this.vXR.get(paramString1);
          if (paramAnonymousn != null)
          {
            paramAnonymousn.state = 1;
            ap.f(new Runnable()
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
          final aj localaj = (aj)b.this.vXR.get(paramString1);
          paramAnonymousn = ((v)paramAnonymousn).drJ().vTP;
          b.this.vXT.put(paramString1, paramAnonymousn);
          b.this.vXU.put(paramString1, paramString2);
          b.this.vXS.remove(paramString1);
          ac.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", new Object[] { paramString1, paramAnonymousn });
          if (localaj != null)
          {
            localaj.state = 2;
            localaj.tBd = paramAnonymousn;
            ap.f(new Runnable()
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
    aj localaj = (aj)this.vXR.get(paramString1);
    if (localaj != null) {
      localaj.state = 1;
    }
    b(localaj);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString2, 0);
    this.vXS.put(paramString1, paramString2);
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
      final aj localaj = (aj)this.vXR.get(paramn);
      if ((localaj != null) && ((paramInt1 != 0) || (paramInt2 != 0)))
      {
        ac.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
        localaj.state = 3;
        this.vXS.remove(paramn);
        com.tencent.mm.kernel.g.agQ().ghe.a(paramString);
        ap.f(new Runnable()
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
    TextView iMz;
    ImageView lzC;
    TextView vXz;
    ProgressBar vYf;
    TextView vYg;
    ImageView vYh;
    ImageView vYi;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void dsd();
    
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b
 * JD-Core Version:    0.7.0.1
 */