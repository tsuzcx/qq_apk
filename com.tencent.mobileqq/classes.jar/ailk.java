import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.mobileqq.surfaceviewaction.gl.Label;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.util.GLUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ailk
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Label jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private final float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int;
  private final float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private int d;
  private int e;
  private int f;
  
  private ailk(SpriteGLView paramSpriteGLView) {}
  
  /* Error */
  @android.annotation.SuppressLint({"DefaultLocale"})
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   4: invokestatic 44	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/lang/Object;
    //   7: astore_1
    //   8: aload_1
    //   9: monitorenter
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: aload_0
    //   14: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   17: invokestatic 47	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   20: invokeinterface 53 1 0
    //   25: if_icmpge +31 -> 56
    //   28: aload_0
    //   29: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   32: invokestatic 47	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   35: iload_2
    //   36: invokeinterface 57 2 0
    //   41: checkcast 59	java/lang/Runnable
    //   44: invokeinterface 62 1 0
    //   49: iload_2
    //   50: iconst_1
    //   51: iadd
    //   52: istore_2
    //   53: goto -41 -> 12
    //   56: aload_0
    //   57: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   60: invokestatic 47	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   63: invokeinterface 65 1 0
    //   68: aload_1
    //   69: monitorexit
    //   70: aload_0
    //   71: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   74: invokestatic 67	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/lang/Object;
    //   77: astore_1
    //   78: aload_1
    //   79: monitorenter
    //   80: iconst_0
    //   81: istore_2
    //   82: iload_2
    //   83: aload_0
    //   84: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   87: invokestatic 69	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   90: invokeinterface 53 1 0
    //   95: if_icmpge +36 -> 131
    //   98: aload_0
    //   99: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   102: invokestatic 69	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   105: iload_2
    //   106: invokeinterface 57 2 0
    //   111: checkcast 59	java/lang/Runnable
    //   114: invokeinterface 62 1 0
    //   119: iload_2
    //   120: iconst_1
    //   121: iadd
    //   122: istore_2
    //   123: goto -41 -> 82
    //   126: astore_3
    //   127: aload_1
    //   128: monitorexit
    //   129: aload_3
    //   130: athrow
    //   131: aload_1
    //   132: monitorexit
    //   133: sipush 16640
    //   136: invokestatic 75	android/opengl/GLES20:glClear	(I)V
    //   139: iconst_0
    //   140: istore_2
    //   141: iload_2
    //   142: aload_0
    //   143: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   146: invokestatic 77	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   149: invokeinterface 53 1 0
    //   154: if_icmpge +95 -> 249
    //   157: sipush 3042
    //   160: invokestatic 80	android/opengl/GLES20:glEnable	(I)V
    //   163: iconst_1
    //   164: sipush 771
    //   167: invokestatic 84	android/opengl/GLES20:glBlendFunc	(II)V
    //   170: aload_0
    //   171: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   174: getfield 86	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:jdField_c_of_type_Int	I
    //   177: invokestatic 89	android/opengl/GLES20:glUseProgram	(I)V
    //   180: aload_0
    //   181: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   184: invokestatic 77	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;)Ljava/util/List;
    //   187: iload_2
    //   188: invokeinterface 57 2 0
    //   193: checkcast 91	com/tencent/mobileqq/surfaceviewaction/gl/Node
    //   196: aload_0
    //   197: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   200: invokevirtual 94	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getWidth	()I
    //   203: aload_0
    //   204: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   207: invokevirtual 97	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getHeight	()I
    //   210: aload_0
    //   211: getfield 99	ailk:jdField_a_of_type_Int	I
    //   214: aload_0
    //   215: getfield 100	ailk:jdField_c_of_type_Int	I
    //   218: aload_0
    //   219: getfield 102	ailk:jdField_b_of_type_Int	I
    //   222: aload_0
    //   223: getfield 104	ailk:d	I
    //   226: aload_0
    //   227: getfield 106	ailk:e	I
    //   230: aload_0
    //   231: getfield 30	ailk:jdField_c_of_type_ArrayOfFloat	[F
    //   234: invokevirtual 109	com/tencent/mobileqq/surfaceviewaction/gl/Node:c	(IIIIIII[F)V
    //   237: iload_2
    //   238: iconst_1
    //   239: iadd
    //   240: istore_2
    //   241: goto -100 -> 141
    //   244: astore_3
    //   245: aload_1
    //   246: monitorexit
    //   247: aload_3
    //   248: athrow
    //   249: aload_0
    //   250: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   253: getfield 112	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:a	Z
    //   256: ifeq +137 -> 393
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 114	ailk:f	I
    //   264: iconst_1
    //   265: iadd
    //   266: putfield 114	ailk:f	I
    //   269: aload_0
    //   270: getfield 114	ailk:f	I
    //   273: iconst_5
    //   274: if_icmplt +64 -> 338
    //   277: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   280: aload_0
    //   281: getfield 122	ailk:jdField_a_of_type_Long	J
    //   284: lsub
    //   285: l2i
    //   286: istore_2
    //   287: ldc 124
    //   289: iconst_1
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: aload_0
    //   296: getfield 114	ailk:f	I
    //   299: i2f
    //   300: ldc 125
    //   302: fmul
    //   303: iload_2
    //   304: i2f
    //   305: fdiv
    //   306: invokestatic 131	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   309: aastore
    //   310: invokestatic 137	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   313: astore_1
    //   314: aload_0
    //   315: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   318: putfield 122	ailk:jdField_a_of_type_Long	J
    //   321: aload_0
    //   322: iconst_0
    //   323: putfield 114	ailk:f	I
    //   326: aload_0
    //   327: getfield 139	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel	Lcom/tencent/mobileqq/surfaceviewaction/gl/Label;
    //   330: aload_0
    //   331: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   334: aload_1
    //   335: invokevirtual 144	com/tencent/mobileqq/surfaceviewaction/gl/Label:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;Ljava/lang/String;)V
    //   338: aload_0
    //   339: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   342: getfield 86	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:jdField_c_of_type_Int	I
    //   345: invokestatic 89	android/opengl/GLES20:glUseProgram	(I)V
    //   348: aload_0
    //   349: getfield 139	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel	Lcom/tencent/mobileqq/surfaceviewaction/gl/Label;
    //   352: aload_0
    //   353: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   356: invokevirtual 94	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getWidth	()I
    //   359: aload_0
    //   360: getfield 21	ailk:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView	Lcom/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView;
    //   363: invokevirtual 97	com/tencent/mobileqq/surfaceviewaction/gl/SpriteGLView:getHeight	()I
    //   366: aload_0
    //   367: getfield 99	ailk:jdField_a_of_type_Int	I
    //   370: aload_0
    //   371: getfield 100	ailk:jdField_c_of_type_Int	I
    //   374: aload_0
    //   375: getfield 102	ailk:jdField_b_of_type_Int	I
    //   378: aload_0
    //   379: getfield 104	ailk:d	I
    //   382: aload_0
    //   383: getfield 106	ailk:e	I
    //   386: aload_0
    //   387: getfield 30	ailk:jdField_c_of_type_ArrayOfFloat	[F
    //   390: invokevirtual 145	com/tencent/mobileqq/surfaceviewaction/gl/Label:c	(IIIIIII[F)V
    //   393: invokestatic 148	android/opengl/GLES20:glFinish	()V
    //   396: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	ailk
    //   0	397	1	paramGL10	GL10
    //   11	293	2	i	int
    //   126	4	3	localObject1	Object
    //   244	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	49	126	finally
    //   56	70	126	finally
    //   127	129	126	finally
    //   82	119	244	finally
    //   131	133	244	finally
    //   245	247	244	finally
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int == 0) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int = GLUtil.a(GLUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "VertexShader.glsl"), GLUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShader.glsl"));
      this.jdField_a_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "vPosition");
      this.jdField_c_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "a_texCoord");
      this.jdField_b_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "uMVPMatrix");
      this.d = GLES20.glGetUniformLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "s_texture");
      this.e = GLES20.glGetUniformLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "v_alpha");
      float f1 = paramInt1 / paramInt2;
      Matrix.frustumM(this.jdField_a_of_type_ArrayOfFloat, 0, -f1, f1, -1.0F, 1.0F, 3.0F, 7.0F);
      Matrix.setLookAtM(this.jdField_b_of_type_ArrayOfFloat, 0, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
      Matrix.multiplyMM(this.jdField_c_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.c = (DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), 50.0F) - paramInt1 / 2);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.d = (DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), 10.0F) - paramInt2 / 2);
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      return;
    }
    catch (Exception paramGL10)
    {
      for (;;)
      {
        QLog.e("SpriteGLView", 2, QLog.getStackTraceString(paramGL10));
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel = new Label(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "fps:", -1, 40);
    SpriteGLView.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailk
 * JD-Core Version:    0.7.0.1
 */