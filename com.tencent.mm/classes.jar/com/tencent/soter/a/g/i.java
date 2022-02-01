package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.c.a;
import com.tencent.soter.a.f.c.b;
import com.tencent.soter.a.f.f.a;
import com.tencent.soter.a.f.f.b;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationResult;
import com.tencent.soter.core.biometric.BiometricManagerCompat.CryptoObject;
import com.tencent.soter.core.c.j;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.security.Signature;
import junit.framework.Assert;

public final class i
  extends d
  implements a
{
  String BVH;
  int JXB;
  private c JXY;
  com.tencent.soter.a.f.f JXZ;
  String JXm;
  private WeakReference<Context> JYa;
  j JYd;
  boolean JYf;
  boolean JYg;
  boolean JYh;
  com.tencent.soter.a.a.a JYp;
  com.tencent.soter.a.a.b JYq;
  private a JYr;
  private int mScene;
  
  public i(b paramb)
  {
    AppMethodBeat.i(93);
    this.mScene = -1;
    this.JXm = null;
    this.BVH = null;
    this.JXY = null;
    this.JXZ = null;
    this.JYa = null;
    this.JYp = null;
    this.JYq = null;
    this.JYd = null;
    this.JYr = null;
    if ((Build.VERSION.SDK_INT < 23) && (Build.MANUFACTURER.equalsIgnoreCase("vivo")))
    {
      bool1 = true;
      this.JYf = bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.JYg = bool1;
      this.JYh = false;
      if (paramb != null) {
        break label138;
      }
      paramb = new IllegalArgumentException("param is null!");
      AppMethodBeat.o(93);
      throw paramb;
      bool1 = false;
      break;
    }
    label138:
    this.mScene = paramb.mScene;
    this.JXY = paramb.JXz;
    this.JXZ = paramb.JXA;
    this.JYa = new WeakReference(paramb.mContext);
    this.JYq = paramb.JXE;
    this.JYp = paramb.JXD;
    this.JXB = paramb.JXB;
    this.BVH = paramb.BVH;
    AppMethodBeat.o(93);
  }
  
  final void b(e parame)
  {
    AppMethodBeat.i(97);
    if (((parame.errCode == 1018) || (parame.errCode == 1007) || (parame.errCode == 1015)) && (com.tencent.soter.a.c.a.a(getClass(), parame)))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: same error happen too much, delete ask", new Object[0]);
      com.tencent.soter.a.a.fDC();
    }
    AppMethodBeat.o(97);
  }
  
  @SuppressLint({"NewApi"})
  final void b(Signature paramSignature)
  {
    String str = null;
    AppMethodBeat.i(99);
    if (this.JXq)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: already finished. can not authenticate", new Object[0]);
      AppMethodBeat.o(99);
      return;
    }
    Object localObject = (Context)this.JYa.get();
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
      c(new com.tencent.soter.a.b.a(1011));
      AppMethodBeat.o(99);
      return;
    }
    try
    {
      com.tencent.soter.core.c.d.v("Soter.TaskBiometricAuthentication", "soter: performing start", new Object[0]);
      localObject = BiometricManagerCompat.from((Context)localObject, Integer.valueOf(this.JXB));
      BiometricManagerCompat.CryptoObject localCryptoObject = new BiometricManagerCompat.CryptoObject(paramSignature);
      paramSignature = str;
      if (this.JYp != null) {
        paramSignature = this.JYp.GnW;
      }
      ((BiometricManagerCompat)localObject).authenticate(localCryptoObject, 0, paramSignature, this.JYr, null);
      AppMethodBeat.o(99);
      return;
    }
    catch (Exception paramSignature)
    {
      str = paramSignature.getMessage();
      com.tencent.soter.core.c.d.e("Soter.TaskBiometricAuthentication", "soter: caused exception when authenticating: %s", new Object[] { str });
      com.tencent.soter.core.c.d.b("Soter.TaskBiometricAuthentication", paramSignature, "soter: caused exception when authenticating");
      c(new com.tencent.soter.a.b.a(1015, String.format("start authentication failed due to %s", new Object[] { str })));
      AppMethodBeat.o(99);
    }
  }
  
  final void execute()
  {
    AppMethodBeat.i(96);
    if (com.tencent.soter.core.c.g.isNullOrNil(this.BVH))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
      this.JXY.cZ(new c.a());
      this.JXY.a(new com.tencent.soter.a.f.b() {});
      this.JXY.execute();
      AppMethodBeat.o(96);
      return;
    }
    com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
    fDQ();
    AppMethodBeat.o(96);
  }
  
  public final void fDJ()
  {
    AppMethodBeat.i(101);
    com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: called from cancellation signal", new Object[0]);
    if (this.JYr != null) {
      this.JYr.onAuthenticationCancelled();
    }
    AppMethodBeat.o(101);
  }
  
  @SuppressLint({"DefaultLocale", "NewApi"})
  final boolean fDK()
  {
    AppMethodBeat.i(94);
    if (!com.tencent.soter.a.c.b.fDE().isInit())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: not initialized yet", new Object[0]);
      c(new com.tencent.soter.a.b.a(1008));
      AppMethodBeat.o(94);
      return true;
    }
    if (!com.tencent.soter.a.c.b.fDE().fDA())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: not support soter", new Object[0]);
      c(new com.tencent.soter.a.b.a(2));
      AppMethodBeat.o(94);
      return true;
    }
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.JXm = ((String)com.tencent.soter.a.c.b.fDE().fDG().get(this.mScene, ""));
      if (!com.tencent.soter.core.c.g.isNullOrNil(this.JXm)) {
        break;
      }
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
      c(new com.tencent.soter.a.b.a(1009, String.format("auth scene %d not initialized in map", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(94);
      return true;
    }
    if (!com.tencent.soter.core.a.aTs(this.JXm))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: auth key %s not exists. need re-generate", new Object[] { this.JXm });
      c(new com.tencent.soter.a.b.a(1006, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(94);
      return true;
    }
    if ((this.JXY == null) && (com.tencent.soter.core.c.g.isNullOrNil(this.BVH)))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: challenge wrapper is null!", new Object[0]);
      c(new com.tencent.soter.a.b.a(1010, "neither get challenge wrapper nor challenge str is found in request parameter"));
      AppMethodBeat.o(94);
      return true;
    }
    Context localContext = (Context)this.JYa.get();
    if (localContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: context instance released in preExecute", new Object[0]);
      c(new com.tencent.soter.a.b.a(1011));
      AppMethodBeat.o(94);
      return true;
    }
    if (!BiometricManagerCompat.from(localContext, Integer.valueOf(this.JXB)).hasEnrolledBiometric())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: user has not enrolled any biometric in system.", new Object[0]);
      c(new com.tencent.soter.a.b.a(1013));
      AppMethodBeat.o(94);
      return true;
    }
    if (com.tencent.soter.core.a.aS(localContext, this.JXB))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: biometric sensor frozen", new Object[0]);
      c(new com.tencent.soter.a.b.a(1021, "Too many failed times"));
      AppMethodBeat.o(94);
      return true;
    }
    if (this.JYp == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
      this.JYp = new com.tencent.soter.a.a.a();
      AppMethodBeat.o(94);
      return false;
    }
    if (this.JXZ == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
    }
    AppMethodBeat.o(94);
    return false;
  }
  
  final void fDL()
  {
    AppMethodBeat.i(95);
    if (this.JYp != null) {
      this.JYp.yE(true);
    }
    AppMethodBeat.o(95);
  }
  
  final void fDQ()
  {
    AppMethodBeat.i(98);
    if (com.tencent.soter.core.a.fDd() == 1)
    {
      localObject = com.tencent.soter.core.a.mn(this.JXm, this.BVH);
      if (localObject == null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
        c(new com.tencent.soter.a.b.a(1007));
        AppMethodBeat.o(98);
        return;
      }
      if (((SoterSessionResult)localObject).bPH != 0)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
        c(new com.tencent.soter.a.b.a(1007));
        AppMethodBeat.o(98);
        return;
      }
      com.tencent.soter.core.c.d.d("Soter.TaskBiometricAuthentication", "soter: session is %d", new Object[] { Long.valueOf(((SoterSessionResult)localObject).dao) });
      this.JYr = new a(null, (byte)0);
      a.a(this.JYr, ((SoterSessionResult)localObject).dao);
      b(null);
      g.fDP().f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(74);
          if (i.this.JYq != null) {
            i.this.JYq.dTc();
          }
          AppMethodBeat.o(74);
        }
      });
      AppMethodBeat.o(98);
      return;
    }
    Object localObject = com.tencent.soter.core.a.aTv(this.JXm);
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign", new Object[0]);
      c(new com.tencent.soter.a.b.a(1007));
      AppMethodBeat.o(98);
      return;
    }
    this.JYr = new a((Signature)localObject, (byte)0);
    b((Signature)localObject);
    g.fDP().f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75);
        if (i.this.JYq != null) {
          i.this.JYq.dTc();
        }
        AppMethodBeat.o(75);
      }
    });
    AppMethodBeat.o(98);
  }
  
  final void fDR()
  {
    AppMethodBeat.i(100);
    if (this.JYd == null)
    {
      c(new com.tencent.soter.a.b.a(1018, "sign failed even after user authenticated the key."));
      AppMethodBeat.o(100);
      return;
    }
    this.JXZ.cZ(new f.a(this.JYd.signature, this.JYd.JWJ, this.JYd.JWI));
    this.JXZ.a(new com.tencent.soter.a.f.b() {});
    this.JXZ.execute();
    AppMethodBeat.o(100);
  }
  
  public final boolean isCancelled()
  {
    return this.JYh;
  }
  
  final class a
    extends BiometricManagerCompat.AuthenticationCallback
  {
    private Signature JYj = null;
    private long dao;
    
    private a(Signature paramSignature)
    {
      this.JYj = paramSignature;
    }
    
    private static String az(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(85);
      if (paramCharSequence == null)
      {
        AppMethodBeat.o(85);
        return "unknown error";
      }
      paramCharSequence = paramCharSequence.toString();
      AppMethodBeat.o(85);
      return paramCharSequence;
    }
    
    @SuppressLint({"NewApi"})
    private void fDT()
    {
      AppMethodBeat.i(91);
      if ((i.this.JYg) || (i.this.JXB == 2))
      {
        i.this.JYp.yE(false);
        i.this.JYh = true;
      }
      AppMethodBeat.o(91);
    }
    
    public final void onAuthenticationCancelled()
    {
      AppMethodBeat.i(90);
      com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
      if (i.this.JYh)
      {
        com.tencent.soter.core.c.d.v("Soter.TaskBiometricAuthentication", "soter: during ignore cancel period", new Object[0]);
        AppMethodBeat.o(90);
        return;
      }
      g.fDP().f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82);
          if (i.this.JYq != null) {
            i.this.JYq.onAuthenticationCancelled();
          }
          AppMethodBeat.o(82);
        }
      });
      i.this.c(new com.tencent.soter.a.b.a(1020, "user cancelled authentication"));
      fDT();
      AppMethodBeat.o(90);
    }
    
    public final void onAuthenticationError(final int paramInt, final CharSequence paramCharSequence)
    {
      AppMethodBeat.i(86);
      com.tencent.soter.core.c.d.e("Soter.TaskBiometricAuthentication", "soter: on authentication fatal error: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
      g.fDP().f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(77);
          if (i.this.JYq != null) {
            i.this.JYq.onAuthenticationError(paramInt, paramCharSequence);
          }
          AppMethodBeat.o(77);
        }
      });
      if (paramInt == 10308) {
        i.this.c(new com.tencent.soter.a.b.a(1022, az(paramCharSequence)));
      }
      for (;;)
      {
        fDT();
        AppMethodBeat.o(86);
        return;
        if (paramInt == 10309) {
          i.this.c(new com.tencent.soter.a.b.a(1022, az(paramCharSequence)));
        } else {
          i.this.c(new com.tencent.soter.a.b.a(1017, az(paramCharSequence)));
        }
      }
    }
    
    public final void onAuthenticationFailed()
    {
      AppMethodBeat.i(89);
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: authentication failed once", new Object[0]);
      g.fDP().f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(81);
          if (i.this.JYq != null) {
            i.this.JYq.onAuthenticationFailed();
          }
          AppMethodBeat.o(81);
        }
      });
      if (i.this.JYf)
      {
        com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: should compat lower android version logic.", new Object[0]);
        i.this.JYp.yE(false);
        g.fDP().ag(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(83);
            i.this.JYp.fDD();
            AppMethodBeat.o(83);
          }
        });
        g.fDP().o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(84);
            i.this.b(i.a.a(i.a.this));
            AppMethodBeat.o(84);
          }
        }, 1000L);
      }
      if (i.this.JXB == 2)
      {
        com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: should compat faceid logic.", new Object[0]);
        i.this.c(new com.tencent.soter.a.b.a(1017, "faceid not match"));
      }
      AppMethodBeat.o(89);
    }
    
    public final void onAuthenticationHelp(final int paramInt, final CharSequence paramCharSequence)
    {
      AppMethodBeat.i(87);
      com.tencent.soter.core.c.d.w("Soter.TaskBiometricAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
      g.fDP().f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78);
          if (i.this.JYq != null) {
            i.this.JYq.onAuthenticationHelp(paramInt, i.a.aA(paramCharSequence));
          }
          AppMethodBeat.o(78);
        }
      });
      AppMethodBeat.o(87);
    }
    
    public final void onAuthenticationSucceeded(BiometricManagerCompat.AuthenticationResult paramAuthenticationResult)
    {
      AppMethodBeat.i(88);
      com.tencent.soter.core.c.d.i("Soter.TaskBiometricAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
      g.fDP().f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(79);
          if (i.this.JYq != null) {
            i.this.JYq.dTd();
          }
          AppMethodBeat.o(79);
        }
      });
      g.fDP().ag(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: bipush 80
          //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   9: getfield 39	com/tencent/soter/a/g/i$a:JYs	Lcom/tencent/soter/a/g/i;
          //   12: getfield 43	com/tencent/soter/a/g/i:BVH	Ljava/lang/String;
          //   15: invokestatic 49	com/tencent/soter/core/c/g:isNullOrNil	(Ljava/lang/String;)Z
          //   18: ifne +426 -> 444
          //   21: invokestatic 55	com/tencent/soter/core/a:fDd	()I
          //   24: iconst_1
          //   25: if_icmpne +139 -> 164
          //   28: aload_0
          //   29: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   32: getfield 39	com/tencent/soter/a/g/i$a:JYs	Lcom/tencent/soter/a/g/i;
          //   35: astore_3
          //   36: aload_0
          //   37: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   40: invokestatic 58	com/tencent/soter/a/g/i$a:a	(Lcom/tencent/soter/a/g/i$a;)Ljava/security/Signature;
          //   43: pop
          //   44: aload_0
          //   45: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   48: invokestatic 62	com/tencent/soter/a/g/i$a:b	(Lcom/tencent/soter/a/g/i$a;)J
          //   51: lstore_1
          //   52: aload_3
          //   53: lload_1
          //   54: invokestatic 66	com/tencent/soter/core/a:BS	(J)[B
          //   57: invokestatic 70	com/tencent/soter/core/a:cK	([B)Lcom/tencent/soter/core/c/j;
          //   60: putfield 74	com/tencent/soter/a/g/i:JYd	Lcom/tencent/soter/core/c/j;
          //   63: aload_3
          //   64: getfield 78	com/tencent/soter/a/g/i:JXZ	Lcom/tencent/soter/a/f/f;
          //   67: ifnull +13 -> 80
          //   70: aload_3
          //   71: invokevirtual 81	com/tencent/soter/a/g/i:fDR	()V
          //   74: bipush 80
          //   76: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   79: return
          //   80: ldc 86
          //   82: ldc 88
          //   84: iconst_0
          //   85: anewarray 4	java/lang/Object
          //   88: invokestatic 93	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   91: aload_3
          //   92: new 95	com/tencent/soter/a/b/a
          //   95: dup
          //   96: aload_3
          //   97: getfield 74	com/tencent/soter/a/g/i:JYd	Lcom/tencent/soter/core/c/j;
          //   100: invokespecial 98	com/tencent/soter/a/b/a:<init>	(Lcom/tencent/soter/core/c/j;)V
          //   103: invokevirtual 102	com/tencent/soter/a/g/i:c	(Lcom/tencent/soter/a/b/e;)V
          //   106: bipush 80
          //   108: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   111: return
          //   112: astore 4
          //   114: ldc 86
          //   116: ldc 104
          //   118: iconst_1
          //   119: anewarray 4	java/lang/Object
          //   122: dup
          //   123: iconst_0
          //   124: aload 4
          //   126: invokevirtual 108	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   129: aastore
          //   130: invokestatic 111	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   133: ldc 86
          //   135: aload 4
          //   137: ldc 113
          //   139: invokestatic 116	com/tencent/soter/core/c/d:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
          //   142: aload_3
          //   143: new 95	com/tencent/soter/a/b/a
          //   146: dup
          //   147: sipush 1018
          //   150: ldc 118
          //   152: invokespecial 121	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
          //   155: invokevirtual 102	com/tencent/soter/a/g/i:c	(Lcom/tencent/soter/a/b/e;)V
          //   158: bipush 80
          //   160: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   163: return
          //   164: aload_0
          //   165: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   168: invokestatic 58	com/tencent/soter/a/g/i$a:a	(Lcom/tencent/soter/a/g/i$a;)Ljava/security/Signature;
          //   171: aload_0
          //   172: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   175: getfield 39	com/tencent/soter/a/g/i$a:JYs	Lcom/tencent/soter/a/g/i;
          //   178: getfield 43	com/tencent/soter/a/g/i:BVH	Ljava/lang/String;
          //   181: ldc 123
          //   183: invokestatic 129	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
          //   186: invokevirtual 135	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
          //   189: invokevirtual 141	java/security/Signature:update	([B)V
          //   192: aload_0
          //   193: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   196: getfield 39	com/tencent/soter/a/g/i$a:JYs	Lcom/tencent/soter/a/g/i;
          //   199: astore_3
          //   200: aload_0
          //   201: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   204: invokestatic 58	com/tencent/soter/a/g/i$a:a	(Lcom/tencent/soter/a/g/i$a;)Ljava/security/Signature;
          //   207: astore 4
          //   209: aload_3
          //   210: aload 4
          //   212: invokevirtual 145	java/security/Signature:sign	()[B
          //   215: invokestatic 70	com/tencent/soter/core/a:cK	([B)Lcom/tencent/soter/core/c/j;
          //   218: putfield 74	com/tencent/soter/a/g/i:JYd	Lcom/tencent/soter/core/c/j;
          //   221: aload_3
          //   222: getfield 78	com/tencent/soter/a/g/i:JXZ	Lcom/tencent/soter/a/f/f;
          //   225: ifnull +149 -> 374
          //   228: aload_3
          //   229: invokevirtual 81	com/tencent/soter/a/g/i:fDR	()V
          //   232: bipush 80
          //   234: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   237: return
          //   238: astore 4
          //   240: ldc 86
          //   242: ldc 147
          //   244: iconst_1
          //   245: anewarray 4	java/lang/Object
          //   248: dup
          //   249: iconst_0
          //   250: aload 4
          //   252: invokevirtual 148	java/security/SignatureException:getMessage	()Ljava/lang/String;
          //   255: aastore
          //   256: invokestatic 111	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   259: ldc 86
          //   261: aload 4
          //   263: ldc 113
          //   265: invokestatic 116	com/tencent/soter/core/c/d:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
          //   268: aload_3
          //   269: new 95	com/tencent/soter/a/b/a
          //   272: dup
          //   273: sipush 1018
          //   276: ldc 118
          //   278: invokespecial 121	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
          //   281: invokevirtual 102	com/tencent/soter/a/g/i:c	(Lcom/tencent/soter/a/b/e;)V
          //   284: bipush 80
          //   286: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   289: return
          //   290: astore_3
          //   291: ldc 86
          //   293: ldc 150
          //   295: iconst_0
          //   296: anewarray 4	java/lang/Object
          //   299: invokestatic 111	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   302: ldc 86
          //   304: aload_3
          //   305: ldc 150
          //   307: invokestatic 116	com/tencent/soter/core/c/d:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
          //   310: ldc 86
          //   312: ldc 152
          //   314: iconst_1
          //   315: anewarray 4	java/lang/Object
          //   318: dup
          //   319: iconst_0
          //   320: aload_0
          //   321: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   324: getfield 39	com/tencent/soter/a/g/i$a:JYs	Lcom/tencent/soter/a/g/i;
          //   327: getfield 155	com/tencent/soter/a/g/i:JXm	Ljava/lang/String;
          //   330: aastore
          //   331: invokestatic 111	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   334: aload_0
          //   335: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   338: getfield 39	com/tencent/soter/a/g/i$a:JYs	Lcom/tencent/soter/a/g/i;
          //   341: getfield 155	com/tencent/soter/a/g/i:JXm	Ljava/lang/String;
          //   344: iconst_0
          //   345: invokestatic 159	com/tencent/soter/core/a:db	(Ljava/lang/String;Z)Lcom/tencent/soter/core/c/f;
          //   348: pop
          //   349: aload_0
          //   350: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   353: getfield 39	com/tencent/soter/a/g/i$a:JYs	Lcom/tencent/soter/a/g/i;
          //   356: new 95	com/tencent/soter/a/b/a
          //   359: dup
          //   360: sipush 1027
          //   363: ldc 161
          //   365: invokespecial 121	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
          //   368: invokevirtual 102	com/tencent/soter/a/g/i:c	(Lcom/tencent/soter/a/b/e;)V
          //   371: goto -179 -> 192
          //   374: ldc 86
          //   376: ldc 88
          //   378: iconst_0
          //   379: anewarray 4	java/lang/Object
          //   382: invokestatic 93	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   385: aload_3
          //   386: new 95	com/tencent/soter/a/b/a
          //   389: dup
          //   390: aload_3
          //   391: getfield 74	com/tencent/soter/a/g/i:JYd	Lcom/tencent/soter/core/c/j;
          //   394: invokespecial 98	com/tencent/soter/a/b/a:<init>	(Lcom/tencent/soter/core/c/j;)V
          //   397: invokevirtual 102	com/tencent/soter/a/g/i:c	(Lcom/tencent/soter/a/b/e;)V
          //   400: bipush 80
          //   402: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   405: return
          //   406: astore_3
          //   407: ldc 86
          //   409: ldc 163
          //   411: iconst_0
          //   412: anewarray 4	java/lang/Object
          //   415: invokestatic 111	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   418: ldc 86
          //   420: aload_3
          //   421: ldc 165
          //   423: invokestatic 116	com/tencent/soter/core/c/d:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
          //   426: aload_0
          //   427: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   430: sipush -1000
          //   433: ldc 167
          //   435: invokevirtual 171	com/tencent/soter/a/g/i$a:onAuthenticationError	(ILjava/lang/CharSequence;)V
          //   438: bipush 80
          //   440: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   443: return
          //   444: ldc 86
          //   446: ldc 173
          //   448: iconst_0
          //   449: anewarray 4	java/lang/Object
          //   452: invokestatic 111	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   455: aload_0
          //   456: getfield 20	com/tencent/soter/a/g/i$a$4:JYt	Lcom/tencent/soter/a/g/i$a;
          //   459: sipush -1000
          //   462: ldc 175
          //   464: invokevirtual 171	com/tencent/soter/a/g/i$a:onAuthenticationError	(ILjava/lang/CharSequence;)V
          //   467: bipush 80
          //   469: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   472: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	473	0	this	4
          //   51	3	1	l	long
          //   35	234	3	locali	i
          //   290	101	3	localSignatureException1	java.security.SignatureException
          //   406	15	3	localException1	Exception
          //   112	24	4	localException2	Exception
          //   207	4	4	localSignature	Signature
          //   238	24	4	localSignatureException2	java.security.SignatureException
          // Exception table:
          //   from	to	target	type
          //   52	79	112	java/lang/Exception
          //   80	106	112	java/lang/Exception
          //   209	237	238	java/security/SignatureException
          //   374	400	238	java/security/SignatureException
          //   164	192	290	java/security/SignatureException
          //   192	209	406	java/lang/Exception
          //   209	237	406	java/lang/Exception
          //   240	284	406	java/lang/Exception
          //   374	400	406	java/lang/Exception
          //   400	405	406	java/lang/Exception
        }
      });
      fDT();
      AppMethodBeat.o(88);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.i
 * JD-Core Version:    0.7.0.1
 */