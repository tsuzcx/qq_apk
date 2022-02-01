package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.Set;

public class SnsAdNativeLandingTestUI
  extends MMActivity
{
  private int JJO;
  private double JtA;
  private VideoSightView KMW;
  SnsAdNativeLandingPagesVideoPlayerLoadingBar KMX;
  private int duration;
  private MMHandler knk;
  private int videoHeight;
  private int videoWidth;
  
  public SnsAdNativeLandingTestUI()
  {
    AppMethodBeat.i(98446);
    this.JtA = 0.0D;
    this.duration = 0;
    this.knk = new MMHandler();
    AppMethodBeat.o(98446);
  }
  
  public int getLayoutId()
  {
    return i.g.sns_ad_native_landing_pages_test_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98447);
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    getWindow().setFlags(1024, 1024);
    ((Button)findViewById(i.f.sns_ad_native_landing_pages_test_share_btn)).setOnClickListener(new SnsAdNativeLandingTestUI.1(this));
    paramBundle = (ViewGroup)findViewById(i.f.sns_ad_native_landing_pages_test_root);
    Object localObject2 = (LayoutInflater)getContext().getSystemService("layout_inflater");
    Object localObject1 = (WindowManager)getContext().getSystemService("window");
    int i = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
    int j = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    localObject1 = com.tencent.mm.loader.j.b.aSL() + "/sns_ad_landingpages";
    String str1 = "adId" + "_image_" + MD5Util.getMD5String("http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150");
    String str2 = "adId" + "_stream_" + MD5Util.getMD5String("http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400");
    localObject2 = ((LayoutInflater)localObject2).inflate(i.g.sns_ad_native_landing_pages_item_sight, null);
    ((View)localObject2).setMinimumHeight(j);
    Object localObject3 = (ViewGroup)((View)localObject2).findViewById(i.f.sns_ad_native_landing_pages_item_sight_container);
    this.KMW = new VideoSightView(getContext());
    this.KMW.setLoop(false);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject3).addView(this.KMW, 0, localLayoutParams);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12);
    ((RelativeLayout.LayoutParams)localObject3).bottomMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), getContext().getResources().getDimension(i.d.NoPadding));
    this.KMX = new SnsAdNativeLandingPagesVideoPlayerLoadingBar(getContext());
    this.KMX.setVisibility(0);
    this.KMW.setPlayProgressCallback(true);
    ((ViewGroup)localObject2).addView(this.KMX, (ViewGroup.LayoutParams)localObject3);
    this.KMX.setIplaySeekCallback(new com.tencent.mm.plugin.sight.decode.ui.b()
    {
      public final void aRo() {}
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(98422);
        Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "onSeek time ".concat(String.valueOf(paramAnonymousInt)));
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this, paramAnonymousInt);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).q(paramAnonymousInt);
        AppMethodBeat.o(98422);
      }
    });
    this.KMX.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98423);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).isPlaying()) {
          SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98423);
          return;
          SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
        }
      }
    });
    this.KMX.setIsPlay(this.KMW.isPlaying());
    this.KMX.setVisibility(0);
    this.KMX.seek(0);
    this.KMW.setVideoCallback(new k.a()
    {
      public final void eM(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(98428);
        SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this, paramAnonymousInt1);
        SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
        AppMethodBeat.o(98428);
      }
      
      public final int fE(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        AppMethodBeat.i(98427);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98424);
            Log.i("MicroMsg.Sns.SnsAdNativieLandingTestUI", "play time " + paramAnonymousInt1 + " video time " + paramAnonymousInt2);
            if (paramAnonymousInt2 > 0)
            {
              SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
              SnsAdNativeLandingTestUI.b(SnsAdNativeLandingTestUI.this, paramAnonymousInt2);
            }
            if (SnsAdNativeLandingTestUI.this.KMX.getVideoTotalTime() != paramAnonymousInt2) {
              SnsAdNativeLandingTestUI.this.KMX.setVideoTotalTime(paramAnonymousInt2);
            }
            SnsAdNativeLandingTestUI.this.KMX.seek(paramAnonymousInt1);
            AppMethodBeat.o(98424);
          }
        });
        AppMethodBeat.o(98427);
        return 0;
      }
      
      public final void onCompletion() {}
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(98426);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).stop();
        AppMethodBeat.o(98426);
      }
      
      public final void qX()
      {
        AppMethodBeat.i(98425);
        if (SnsAdNativeLandingTestUI.this.KMX.getIsPlay()) {
          SnsAdNativeLandingTestUI.c(SnsAdNativeLandingTestUI.this);
        }
        AppMethodBeat.o(98425);
      }
    });
    this.KMW.setEnableConfigChanged(false);
    this.KMW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((!"".equals(SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath())) && (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath() != null))
        {
          if (SnsAdNativeLandingTestUI.this.KMX.getVisibility() != 0) {
            break label107;
          }
          SnsAdNativeLandingTestUI.this.KMX.setVisibility(4);
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98429);
          return;
          label107:
          SnsAdNativeLandingTestUI.this.KMX.setVisibility(0);
        }
      }
    });
    paramBundle.addView((View)localObject2, new LinearLayout.LayoutParams(i, j));
    this.KMW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98430);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        if ((SnsAdNativeLandingTestUI.this.getContext() instanceof MMActivity))
        {
          ((MMActivity)SnsAdNativeLandingTestUI.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setDrawableWidth(localDisplayMetrics.widthPixels);
        }
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).requestLayout();
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).postInvalidate();
        AppMethodBeat.o(98430);
      }
    });
    new a((String)localObject1, str1, aj.etE(), new SnsAdNativeLandingTestUI.a.a()
    {
      public final void Oy(String paramAnonymousString)
      {
        AppMethodBeat.i(98431);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setThumb(BitmapUtil.decodeFile(paramAnonymousString));
        AppMethodBeat.o(98431);
      }
      
      public final void aij(String paramAnonymousString) {}
      
      public final void dT(String paramAnonymousString, int paramAnonymousInt) {}
    }).execute(new String[] { "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150" });
    new a((String)localObject1, str2, aj.etE(), new SnsAdNativeLandingTestUI.a.a()
    {
      public final void Oy(String paramAnonymousString)
      {
        AppMethodBeat.i(98434);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setVideoPath(paramAnonymousString);
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setLoop(true);
        if (SnsAdNativeLandingTestUI.this.KMX.getIsPlay())
        {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).q(SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this));
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).start();
        }
        AppMethodBeat.o(98434);
      }
      
      public final void aij(String paramAnonymousString)
      {
        AppMethodBeat.i(98433);
        Log.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", paramAnonymousString);
        AppMethodBeat.o(98433);
      }
      
      public final void dT(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(98432);
        if (SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).isPlaying())
        {
          AppMethodBeat.o(98432);
          return;
        }
        SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setLoop(false);
        if (!paramAnonymousString.equals(SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).getVideoPath())) {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).setVideoPath(paramAnonymousString);
        }
        if (SnsAdNativeLandingTestUI.this.KMX.getIsPlay())
        {
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).q(SnsAdNativeLandingTestUI.d(SnsAdNativeLandingTestUI.this));
          SnsAdNativeLandingTestUI.a(SnsAdNativeLandingTestUI.this).start();
        }
        AppMethodBeat.o(98432);
      }
    }, 409600).execute(new String[] { "http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804105d999cf2831eae6ca6e65b177800230f0204009297fd0400&amp;bizid=1023&amp;hy=SH&amp;fileparam=302c020101042530230204136ffd9302045719f85d02024ef202031e8d7f02030f42400204045a320a0201000400" });
    AppMethodBeat.o(98447);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends AsyncTask<String, Void, Void>
  {
    private static Set<String> KNc;
    private static byte[] KNd;
    final a KNe;
    final String KxY;
    final String KxZ;
    final int Kyb;
    final String Kyc;
    final String fileName;
    final String filePath;
    final MMHandler handler;
    
    static
    {
      AppMethodBeat.i(98445);
      KNc = new HashSet();
      KNd = new byte[0];
      AppMethodBeat.o(98445);
    }
    
    public a(String paramString1, String paramString2, MMHandler paramMMHandler, a parama)
    {
      this(paramString1, paramString2, paramMMHandler, parama, 0);
    }
    
    public a(String paramString1, String paramString2, final MMHandler paramMMHandler, final a parama, int paramInt)
    {
      AppMethodBeat.i(98442);
      u.bBD(paramString1);
      this.Kyc = paramString1;
      this.fileName = paramString2;
      this.filePath = (paramString1 + "/" + paramString2);
      this.KxZ = "temp_".concat(String.valueOf(paramString2));
      this.KxY = (paramString1 + "/" + this.KxZ);
      this.handler = paramMMHandler;
      this.Kyb = paramInt;
      this.KNe = new a()
      {
        public final void Oy(final String paramAnonymousString)
        {
          AppMethodBeat.i(98441);
          paramMMHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98438);
              SnsAdNativeLandingTestUI.a.1.this.KNf.Oy(paramAnonymousString);
              AppMethodBeat.o(98438);
            }
          });
          AppMethodBeat.o(98441);
        }
        
        public final void aij(final String paramAnonymousString)
        {
          AppMethodBeat.i(98440);
          paramMMHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98437);
              SnsAdNativeLandingTestUI.a.1.this.KNf.aij(paramAnonymousString);
              AppMethodBeat.o(98437);
            }
          });
          AppMethodBeat.o(98440);
        }
        
        public final void dT(final String paramAnonymousString, final int paramAnonymousInt)
        {
          AppMethodBeat.i(98439);
          paramMMHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98436);
              SnsAdNativeLandingTestUI.a.1.this.KNf.dT(paramAnonymousString, paramAnonymousInt);
              AppMethodBeat.o(98436);
            }
          });
          AppMethodBeat.o(98439);
        }
      };
      AppMethodBeat.o(98442);
    }
    
    /* Error */
    private Void P(String... paramVarArgs)
    {
      // Byte code:
      //   0: ldc 120
      //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNd	[B
      //   8: astore 5
      //   10: aload 5
      //   12: monitorenter
      //   13: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNc	Ljava/util/Set;
      //   16: aload_1
      //   17: iconst_0
      //   18: aaload
      //   19: invokeinterface 126 2 0
      //   24: ifeq +13 -> 37
      //   27: aload 5
      //   29: monitorexit
      //   30: ldc 120
      //   32: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   35: aconst_null
      //   36: areturn
      //   37: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNc	Ljava/util/Set;
      //   40: aload_1
      //   41: iconst_0
      //   42: aaload
      //   43: invokeinterface 129 2 0
      //   48: pop
      //   49: aload 5
      //   51: monitorexit
      //   52: aload_0
      //   53: getfield 88	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
      //   56: invokestatic 132	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
      //   59: ifeq +68 -> 127
      //   62: aload_0
      //   63: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNe	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   66: aload_0
      //   67: getfield 88	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
      //   70: invokeinterface 136 2 0
      //   75: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNd	[B
      //   78: astore 5
      //   80: aload 5
      //   82: monitorenter
      //   83: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNc	Ljava/util/Set;
      //   86: aload_1
      //   87: iconst_0
      //   88: aaload
      //   89: invokeinterface 139 2 0
      //   94: pop
      //   95: aload 5
      //   97: monitorexit
      //   98: ldc 120
      //   100: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   103: aconst_null
      //   104: areturn
      //   105: astore_1
      //   106: aload 5
      //   108: monitorexit
      //   109: ldc 120
      //   111: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   114: aload_1
      //   115: athrow
      //   116: astore_1
      //   117: aload 5
      //   119: monitorexit
      //   120: ldc 120
      //   122: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: aload_1
      //   126: athrow
      //   127: aload_0
      //   128: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KxY	Ljava/lang/String;
      //   131: invokestatic 132	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
      //   134: ifeq +11 -> 145
      //   137: aload_0
      //   138: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KxY	Ljava/lang/String;
      //   141: invokestatic 142	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
      //   144: pop
      //   145: new 144	java/net/URL
      //   148: dup
      //   149: aload_1
      //   150: iconst_0
      //   151: aaload
      //   152: invokespecial 146	java/net/URL:<init>	(Ljava/lang/String;)V
      //   155: invokevirtual 150	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   158: checkcast 152	java/net/HttpURLConnection
      //   161: astore 5
      //   163: aload 5
      //   165: invokevirtual 155	java/net/HttpURLConnection:connect	()V
      //   168: aload 5
      //   170: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
      //   173: sipush 200
      //   176: if_icmpeq +119 -> 295
      //   179: aload_0
      //   180: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNe	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   183: new 75	java/lang/StringBuilder
      //   186: dup
      //   187: ldc 161
      //   189: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   192: aload 5
      //   194: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
      //   197: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   200: ldc 167
      //   202: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   205: aload 5
      //   207: invokevirtual 170	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
      //   210: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   213: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   216: invokeinterface 173 2 0
      //   221: aload 5
      //   223: ifnull +16 -> 239
      //   226: aload 5
      //   228: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   231: invokevirtual 182	java/io/InputStream:close	()V
      //   234: aload 5
      //   236: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
      //   239: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNd	[B
      //   242: astore 5
      //   244: aload 5
      //   246: monitorenter
      //   247: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNc	Ljava/util/Set;
      //   250: aload_1
      //   251: iconst_0
      //   252: aaload
      //   253: invokeinterface 139 2 0
      //   258: pop
      //   259: aload 5
      //   261: monitorexit
      //   262: ldc 120
      //   264: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   267: aconst_null
      //   268: areturn
      //   269: astore 6
      //   271: ldc 187
      //   273: aload 6
      //   275: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   278: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   281: goto -47 -> 234
      //   284: astore_1
      //   285: aload 5
      //   287: monitorexit
      //   288: ldc 120
      //   290: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   293: aload_1
      //   294: athrow
      //   295: aload 5
      //   297: invokevirtual 199	java/net/HttpURLConnection:getContentLength	()I
      //   300: pop
      //   301: aload 5
      //   303: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   306: astore 8
      //   308: aload_0
      //   309: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KxY	Ljava/lang/String;
      //   312: invokestatic 203	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
      //   315: astore 7
      //   317: sipush 4096
      //   320: newarray byte
      //   322: astore 6
      //   324: iconst_0
      //   325: istore_3
      //   326: iconst_0
      //   327: istore_2
      //   328: aload 8
      //   330: aload 6
      //   332: invokevirtual 207	java/io/InputStream:read	([B)I
      //   335: istore 4
      //   337: iload 4
      //   339: iconst_m1
      //   340: if_icmpeq +54 -> 394
      //   343: aload 7
      //   345: aload 6
      //   347: iconst_0
      //   348: iload 4
      //   350: invokevirtual 213	java/io/OutputStream:write	([BII)V
      //   353: iload 4
      //   355: iload_2
      //   356: iadd
      //   357: istore_2
      //   358: aload_0
      //   359: getfield 108	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:Kyb	I
      //   362: ifeq +492 -> 854
      //   365: iload_2
      //   366: iload_3
      //   367: isub
      //   368: aload_0
      //   369: getfield 108	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:Kyb	I
      //   372: if_icmplt +482 -> 854
      //   375: aload_0
      //   376: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNe	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   379: aload_0
      //   380: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KxY	Ljava/lang/String;
      //   383: iload_2
      //   384: invokeinterface 217 3 0
      //   389: iload_2
      //   390: istore_3
      //   391: goto -63 -> 328
      //   394: aload_0
      //   395: getfield 104	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KxY	Ljava/lang/String;
      //   398: aload_0
      //   399: getfield 88	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
      //   402: invokestatic 221	com/tencent/mm/vfs/u:oo	(Ljava/lang/String;Ljava/lang/String;)Z
      //   405: pop
      //   406: aload_0
      //   407: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNe	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   410: aload_0
      //   411: getfield 88	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:filePath	Ljava/lang/String;
      //   414: invokeinterface 136 2 0
      //   419: aload 7
      //   421: ifnull +8 -> 429
      //   424: aload 7
      //   426: invokevirtual 222	java/io/OutputStream:close	()V
      //   429: aload 8
      //   431: ifnull +8 -> 439
      //   434: aload 8
      //   436: invokevirtual 182	java/io/InputStream:close	()V
      //   439: aload 5
      //   441: ifnull +16 -> 457
      //   444: aload 5
      //   446: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   449: invokevirtual 182	java/io/InputStream:close	()V
      //   452: aload 5
      //   454: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
      //   457: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNd	[B
      //   460: astore 5
      //   462: aload 5
      //   464: monitorenter
      //   465: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNc	Ljava/util/Set;
      //   468: aload_1
      //   469: iconst_0
      //   470: aaload
      //   471: invokeinterface 139 2 0
      //   476: pop
      //   477: aload 5
      //   479: monitorexit
      //   480: ldc 120
      //   482: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   485: aconst_null
      //   486: areturn
      //   487: astore 6
      //   489: ldc 187
      //   491: aload 6
      //   493: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   496: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   499: goto -47 -> 452
      //   502: astore_1
      //   503: aload 5
      //   505: monitorexit
      //   506: ldc 120
      //   508: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   511: aload_1
      //   512: athrow
      //   513: astore 5
      //   515: aconst_null
      //   516: astore 6
      //   518: aconst_null
      //   519: astore 7
      //   521: aconst_null
      //   522: astore 8
      //   524: aload_0
      //   525: getfield 113	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNe	Lcom/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a$a;
      //   528: aload 5
      //   530: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   533: invokeinterface 173 2 0
      //   538: aload 7
      //   540: ifnull +8 -> 548
      //   543: aload 7
      //   545: invokevirtual 222	java/io/OutputStream:close	()V
      //   548: aload 8
      //   550: ifnull +8 -> 558
      //   553: aload 8
      //   555: invokevirtual 182	java/io/InputStream:close	()V
      //   558: aload 6
      //   560: ifnull +16 -> 576
      //   563: aload 6
      //   565: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   568: invokevirtual 182	java/io/InputStream:close	()V
      //   571: aload 6
      //   573: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
      //   576: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNd	[B
      //   579: astore 5
      //   581: aload 5
      //   583: monitorenter
      //   584: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNc	Ljava/util/Set;
      //   587: aload_1
      //   588: iconst_0
      //   589: aaload
      //   590: invokeinterface 139 2 0
      //   595: pop
      //   596: aload 5
      //   598: monitorexit
      //   599: ldc 120
      //   601: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   604: aconst_null
      //   605: areturn
      //   606: astore 5
      //   608: ldc 187
      //   610: aload 5
      //   612: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   615: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   618: goto -47 -> 571
      //   621: astore_1
      //   622: aload 5
      //   624: monitorexit
      //   625: ldc 120
      //   627: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   630: aload_1
      //   631: athrow
      //   632: astore 5
      //   634: aconst_null
      //   635: astore 6
      //   637: aconst_null
      //   638: astore 7
      //   640: aconst_null
      //   641: astore 8
      //   643: aload 7
      //   645: ifnull +8 -> 653
      //   648: aload 7
      //   650: invokevirtual 222	java/io/OutputStream:close	()V
      //   653: aload 8
      //   655: ifnull +8 -> 663
      //   658: aload 8
      //   660: invokevirtual 182	java/io/InputStream:close	()V
      //   663: aload 6
      //   665: ifnull +16 -> 681
      //   668: aload 6
      //   670: invokevirtual 177	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   673: invokevirtual 182	java/io/InputStream:close	()V
      //   676: aload 6
      //   678: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
      //   681: getstatic 53	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNd	[B
      //   684: astore 6
      //   686: aload 6
      //   688: monitorenter
      //   689: getstatic 51	com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingTestUI$a:KNc	Ljava/util/Set;
      //   692: aload_1
      //   693: iconst_0
      //   694: aaload
      //   695: invokeinterface 139 2 0
      //   700: pop
      //   701: aload 6
      //   703: monitorexit
      //   704: ldc 120
      //   706: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   709: aload 5
      //   711: athrow
      //   712: astore 7
      //   714: ldc 187
      //   716: aload 7
      //   718: invokevirtual 190	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   721: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   724: goto -48 -> 676
      //   727: astore_1
      //   728: aload 6
      //   730: monitorexit
      //   731: ldc 120
      //   733: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   736: aload_1
      //   737: athrow
      //   738: astore 7
      //   740: goto -77 -> 663
      //   743: astore 9
      //   745: aload 5
      //   747: astore 6
      //   749: aconst_null
      //   750: astore 7
      //   752: aconst_null
      //   753: astore 8
      //   755: aload 9
      //   757: astore 5
      //   759: goto -116 -> 643
      //   762: astore 9
      //   764: aload 5
      //   766: astore 6
      //   768: aconst_null
      //   769: astore 7
      //   771: aload 9
      //   773: astore 5
      //   775: goto -132 -> 643
      //   778: astore 9
      //   780: aload 5
      //   782: astore 6
      //   784: aload 9
      //   786: astore 5
      //   788: goto -145 -> 643
      //   791: astore 5
      //   793: goto -150 -> 643
      //   796: astore 5
      //   798: goto -240 -> 558
      //   801: astore 9
      //   803: aload 5
      //   805: astore 6
      //   807: aconst_null
      //   808: astore 7
      //   810: aconst_null
      //   811: astore 8
      //   813: aload 9
      //   815: astore 5
      //   817: goto -293 -> 524
      //   820: astore 9
      //   822: aload 5
      //   824: astore 6
      //   826: aconst_null
      //   827: astore 7
      //   829: aload 9
      //   831: astore 5
      //   833: goto -309 -> 524
      //   836: astore 9
      //   838: aload 5
      //   840: astore 6
      //   842: aload 9
      //   844: astore 5
      //   846: goto -322 -> 524
      //   849: astore 6
      //   851: goto -412 -> 439
      //   854: goto -526 -> 328
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	857	0	this	a
      //   0	857	1	paramVarArgs	String[]
      //   327	63	2	i	int
      //   325	66	3	j	int
      //   335	22	4	k	int
      //   8	496	5	localObject1	Object
      //   513	16	5	localException1	java.lang.Exception
      //   579	18	5	arrayOfByte1	byte[]
      //   606	17	5	localException2	java.lang.Exception
      //   632	114	5	localObject2	Object
      //   757	30	5	localObject3	Object
      //   791	1	5	localObject4	Object
      //   796	8	5	localIOException1	java.io.IOException
      //   815	30	5	localObject5	Object
      //   269	5	6	localException3	java.lang.Exception
      //   322	24	6	arrayOfByte2	byte[]
      //   487	5	6	localException4	java.lang.Exception
      //   849	1	6	localIOException2	java.io.IOException
      //   315	334	7	localOutputStream	java.io.OutputStream
      //   712	5	7	localException5	java.lang.Exception
      //   738	1	7	localIOException3	java.io.IOException
      //   750	78	7	localObject7	Object
      //   306	506	8	localInputStream	java.io.InputStream
      //   743	13	9	localObject8	Object
      //   762	10	9	localObject9	Object
      //   778	7	9	localObject10	Object
      //   801	13	9	localException6	java.lang.Exception
      //   820	10	9	localException7	java.lang.Exception
      //   836	7	9	localException8	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   13	30	105	finally
      //   37	52	105	finally
      //   83	98	116	finally
      //   226	234	269	java/lang/Exception
      //   247	262	284	finally
      //   444	452	487	java/lang/Exception
      //   465	480	502	finally
      //   52	75	513	java/lang/Exception
      //   127	145	513	java/lang/Exception
      //   145	163	513	java/lang/Exception
      //   563	571	606	java/lang/Exception
      //   584	599	621	finally
      //   52	75	632	finally
      //   127	145	632	finally
      //   145	163	632	finally
      //   668	676	712	java/lang/Exception
      //   689	704	727	finally
      //   648	653	738	java/io/IOException
      //   658	663	738	java/io/IOException
      //   163	221	743	finally
      //   295	308	743	finally
      //   308	317	762	finally
      //   317	324	778	finally
      //   328	337	778	finally
      //   343	353	778	finally
      //   358	389	778	finally
      //   394	419	778	finally
      //   524	538	791	finally
      //   543	548	796	java/io/IOException
      //   553	558	796	java/io/IOException
      //   163	221	801	java/lang/Exception
      //   295	308	801	java/lang/Exception
      //   308	317	820	java/lang/Exception
      //   317	324	836	java/lang/Exception
      //   328	337	836	java/lang/Exception
      //   343	353	836	java/lang/Exception
      //   358	389	836	java/lang/Exception
      //   394	419	836	java/lang/Exception
      //   424	429	849	java/io/IOException
      //   434	439	849	java/io/IOException
    }
    
    static abstract interface a
    {
      public abstract void Oy(String paramString);
      
      public abstract void aij(String paramString);
      
      public abstract void dT(String paramString, int paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI
 * JD-Core Version:    0.7.0.1
 */