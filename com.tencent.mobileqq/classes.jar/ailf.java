import com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView;

public class ailf
  implements Runnable
{
  public boolean a;
  
  private ailf(GLTextureView paramGLTextureView) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 33
    //   10: iconst_2
    //   11: ldc 35
    //   13: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: ldc 41
    //   18: monitorenter
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 43	ailf:jdField_a_of_type_Boolean	Z
    //   24: ldc 41
    //   26: monitorexit
    //   27: aload_0
    //   28: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   31: iconst_1
    //   32: invokestatic 46	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;Z)Z
    //   35: pop
    //   36: aload_0
    //   37: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   40: invokestatic 48	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
    //   43: aload_0
    //   44: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   47: invokestatic 51	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
    //   50: iconst_0
    //   51: istore_1
    //   52: iload_1
    //   53: aload_0
    //   54: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   57: invokestatic 54	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   60: invokeinterface 60 1 0
    //   65: if_icmpge +39 -> 104
    //   68: aload_0
    //   69: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   72: invokestatic 54	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   75: iload_1
    //   76: invokeinterface 64 2 0
    //   81: checkcast 66	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$OnSurfaceChangedListener
    //   84: invokeinterface 68 1 0
    //   89: iload_1
    //   90: iconst_1
    //   91: iadd
    //   92: istore_1
    //   93: goto -41 -> 52
    //   96: astore 7
    //   98: ldc 41
    //   100: monitorexit
    //   101: aload 7
    //   103: athrow
    //   104: aload_0
    //   105: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   108: new 70	ailg
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 73	ailg:<init>	(Lailf;)V
    //   116: invokevirtual 77	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:post	(Ljava/lang/Runnable;)Z
    //   119: pop
    //   120: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   123: lstore_3
    //   124: aload_0
    //   125: getfield 43	ailf:jdField_a_of_type_Boolean	Z
    //   128: ifeq +303 -> 431
    //   131: aload_0
    //   132: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   135: invokestatic 86	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   138: ifnonnull +17 -> 155
    //   141: ldc2_w 87
    //   144: invokestatic 94	java/lang/Thread:sleep	(J)V
    //   147: goto -16 -> 131
    //   150: astore 7
    //   152: goto -21 -> 131
    //   155: aload_0
    //   156: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   159: invokestatic 97	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   162: ifeq +26 -> 188
    //   165: aload_0
    //   166: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   169: aload_0
    //   170: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   173: invokestatic 86	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   176: invokestatic 100	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;Landroid/opengl/GLSurfaceView$Renderer;)V
    //   179: aload_0
    //   180: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   183: iconst_0
    //   184: invokestatic 46	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;Z)Z
    //   187: pop
    //   188: aload_0
    //   189: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   192: invokestatic 102	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   195: ifne +376 -> 571
    //   198: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   201: lstore_3
    //   202: aload_0
    //   203: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   206: invokestatic 105	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/lang/Object;
    //   209: astore 7
    //   211: aload 7
    //   213: monitorenter
    //   214: iconst_0
    //   215: istore_1
    //   216: iload_1
    //   217: aload_0
    //   218: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   221: invokestatic 107	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   224: invokeinterface 60 1 0
    //   229: if_icmpge +31 -> 260
    //   232: aload_0
    //   233: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   236: invokestatic 107	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   239: iload_1
    //   240: invokeinterface 64 2 0
    //   245: checkcast 6	java/lang/Runnable
    //   248: invokeinterface 109 1 0
    //   253: iload_1
    //   254: iconst_1
    //   255: iadd
    //   256: istore_1
    //   257: goto -41 -> 216
    //   260: aload_0
    //   261: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   264: invokestatic 107	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   267: invokeinterface 112 1 0
    //   272: aload 7
    //   274: monitorexit
    //   275: ldc 41
    //   277: monitorenter
    //   278: aload_0
    //   279: getfield 43	ailf:jdField_a_of_type_Boolean	Z
    //   282: ifeq +20 -> 302
    //   285: aload_0
    //   286: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   289: invokestatic 115	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   292: ifne +10 -> 302
    //   295: aload_0
    //   296: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   299: invokestatic 117	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
    //   302: ldc 41
    //   304: monitorexit
    //   305: aload_0
    //   306: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   309: invokestatic 102	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   312: ifne +13 -> 325
    //   315: aload_0
    //   316: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   319: invokestatic 115	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   322: ifeq +68 -> 390
    //   325: ldc2_w 87
    //   328: invokestatic 94	java/lang/Thread:sleep	(J)V
    //   331: goto -207 -> 124
    //   334: astore 8
    //   336: aload 7
    //   338: monitorexit
    //   339: aload 8
    //   341: athrow
    //   342: astore 7
    //   344: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -45 -> 302
    //   350: ldc 33
    //   352: iconst_2
    //   353: new 119	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   360: ldc 122
    //   362: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 7
    //   367: invokestatic 130	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   370: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: goto -77 -> 302
    //   382: astore 7
    //   384: ldc 41
    //   386: monitorexit
    //   387: aload 7
    //   389: athrow
    //   390: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   393: lstore 5
    //   395: ldc2_w 138
    //   398: aload_0
    //   399: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   402: invokestatic 142	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)I
    //   405: i2l
    //   406: lload 5
    //   408: lload_3
    //   409: lsub
    //   410: lsub
    //   411: invokestatic 148	java/lang/Math:max	(JJ)J
    //   414: invokestatic 94	java/lang/Thread:sleep	(J)V
    //   417: lload 5
    //   419: lstore_3
    //   420: goto -296 -> 124
    //   423: astore 7
    //   425: lload 5
    //   427: lstore_3
    //   428: goto -304 -> 124
    //   431: aload_0
    //   432: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   435: invokestatic 105	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/lang/Object;
    //   438: astore 7
    //   440: aload 7
    //   442: monitorenter
    //   443: iconst_0
    //   444: istore_1
    //   445: iload_1
    //   446: aload_0
    //   447: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   450: invokestatic 107	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   453: invokeinterface 60 1 0
    //   458: if_icmpge +31 -> 489
    //   461: aload_0
    //   462: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   465: invokestatic 107	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   468: iload_1
    //   469: invokeinterface 64 2 0
    //   474: checkcast 6	java/lang/Runnable
    //   477: invokeinterface 109 1 0
    //   482: iload_1
    //   483: iconst_1
    //   484: iadd
    //   485: istore_1
    //   486: goto -41 -> 445
    //   489: aload_0
    //   490: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   493: invokestatic 107	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   496: invokeinterface 112 1 0
    //   501: aload 7
    //   503: monitorexit
    //   504: aload_0
    //   505: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   508: invokestatic 150	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:d	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
    //   511: iload_2
    //   512: istore_1
    //   513: iload_1
    //   514: aload_0
    //   515: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   518: invokestatic 54	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   521: invokeinterface 60 1 0
    //   526: if_icmpge +39 -> 565
    //   529: aload_0
    //   530: getfield 13	ailf:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlGLTextureView	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   533: invokestatic 54	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   536: iload_1
    //   537: invokeinterface 64 2 0
    //   542: checkcast 66	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$OnSurfaceChangedListener
    //   545: invokeinterface 152 1 0
    //   550: iload_1
    //   551: iconst_1
    //   552: iadd
    //   553: istore_1
    //   554: goto -41 -> 513
    //   557: astore 8
    //   559: aload 7
    //   561: monitorexit
    //   562: aload 8
    //   564: athrow
    //   565: return
    //   566: astore 7
    //   568: goto -444 -> 124
    //   571: goto -266 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	this	ailf
    //   51	503	1	i	int
    //   1	511	2	j	int
    //   123	305	3	l1	long
    //   393	33	5	l2	long
    //   96	6	7	localObject1	Object
    //   150	1	7	localInterruptedException1	java.lang.InterruptedException
    //   209	128	7	localObject2	Object
    //   342	24	7	localException	java.lang.Exception
    //   382	6	7	localObject3	Object
    //   423	1	7	localInterruptedException2	java.lang.InterruptedException
    //   438	122	7	localObject4	Object
    //   566	1	7	localInterruptedException3	java.lang.InterruptedException
    //   334	6	8	localObject5	Object
    //   557	6	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   19	27	96	finally
    //   98	101	96	finally
    //   141	147	150	java/lang/InterruptedException
    //   216	253	334	finally
    //   260	275	334	finally
    //   336	339	334	finally
    //   278	302	342	java/lang/Exception
    //   278	302	382	finally
    //   302	305	382	finally
    //   344	379	382	finally
    //   384	387	382	finally
    //   395	417	423	java/lang/InterruptedException
    //   445	482	557	finally
    //   489	504	557	finally
    //   559	562	557	finally
    //   305	325	566	java/lang/InterruptedException
    //   325	331	566	java/lang/InterruptedException
    //   390	395	566	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailf
 * JD-Core Version:    0.7.0.1
 */