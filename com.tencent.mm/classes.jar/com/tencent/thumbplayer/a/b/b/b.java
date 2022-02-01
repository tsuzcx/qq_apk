package com.tencent.thumbplayer.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.b.c.a;
import com.tencent.thumbplayer.api.TPCommonEnum.TPOptionalId;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.g.a;
import com.tencent.thumbplayer.utils.g;
import java.lang.reflect.Field;

public final class b
{
  /* Error */
  @com.tencent.thumbplayer.api.TPCommonEnum.NativeSeekMode
  public static int ara(@com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode int paramInt)
  {
    // Byte code:
    //   0: ldc 13
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 21
    //   7: invokevirtual 27	java/lang/Class:getName	()Ljava/lang/String;
    //   10: invokestatic 31	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 35	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   18: astore 4
    //   20: aload 4
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iload_2
    //   28: if_icmpge +87 -> 115
    //   31: aload 4
    //   33: iload_1
    //   34: aaload
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 41	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   42: invokevirtual 44	java/lang/Class:toString	()Ljava/lang/String;
    //   45: ldc 46
    //   47: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +51 -> 101
    //   53: aload 5
    //   55: iconst_1
    //   56: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   59: iload_0
    //   60: aload 5
    //   62: aload_3
    //   63: invokevirtual 60	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   66: if_icmpne +35 -> 101
    //   69: aload 5
    //   71: ldc 62
    //   73: invokevirtual 66	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   76: checkcast 62	com/tencent/thumbplayer/a/b/b/a$h
    //   79: astore 5
    //   81: aload 5
    //   83: ifnull +18 -> 101
    //   86: aload 5
    //   88: invokeinterface 70 1 0
    //   93: istore_1
    //   94: ldc 13
    //   96: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iload_1
    //   100: ireturn
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -79 -> 26
    //   108: astore_3
    //   109: ldc 75
    //   111: aload_3
    //   112: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: ldc 75
    //   117: new 83	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 85
    //   123: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: iload_0
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc 95
    //   132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 103	com/tencent/thumbplayer/utils/g:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc 13
    //   143: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_2
    //   147: ireturn
    //   148: astore_3
    //   149: ldc 75
    //   151: aload_3
    //   152: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -40 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramInt	int
    //   25	80	1	i	int
    //   23	6	2	j	int
    //   13	50	3	localClass	Class
    //   108	4	3	localClassNotFoundException	ClassNotFoundException
    //   148	4	3	localIllegalAccessException	IllegalAccessException
    //   18	14	4	arrayOfField	Field[]
    //   35	52	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	108	java/lang/ClassNotFoundException
    //   37	81	108	java/lang/ClassNotFoundException
    //   86	94	108	java/lang/ClassNotFoundException
    //   5	24	148	java/lang/IllegalAccessException
    //   37	81	148	java/lang/IllegalAccessException
    //   86	94	148	java/lang/IllegalAccessException
  }
  
  /* Error */
  @com.tencent.thumbplayer.api.TPCommonEnum.NativeSwitchDefMode
  public static int arb(@com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode int paramInt)
  {
    // Byte code:
    //   0: ldc 110
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 21
    //   7: invokevirtual 27	java/lang/Class:getName	()Ljava/lang/String;
    //   10: invokestatic 31	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 35	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   18: astore 4
    //   20: aload 4
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iload_2
    //   28: if_icmpge +87 -> 115
    //   31: aload 4
    //   33: iload_1
    //   34: aaload
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 41	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   42: invokevirtual 44	java/lang/Class:toString	()Ljava/lang/String;
    //   45: ldc 46
    //   47: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +51 -> 101
    //   53: aload 5
    //   55: iconst_1
    //   56: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   59: iload_0
    //   60: aload 5
    //   62: aload_3
    //   63: invokevirtual 60	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   66: if_icmpne +35 -> 101
    //   69: aload 5
    //   71: ldc 112
    //   73: invokevirtual 66	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   76: checkcast 112	com/tencent/thumbplayer/a/b/b/a$i
    //   79: astore 5
    //   81: aload 5
    //   83: ifnull +18 -> 101
    //   86: aload 5
    //   88: invokeinterface 113 1 0
    //   93: istore_1
    //   94: ldc 110
    //   96: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iload_1
    //   100: ireturn
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -79 -> 26
    //   108: astore_3
    //   109: ldc 75
    //   111: aload_3
    //   112: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: ldc 75
    //   117: new 83	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 115
    //   123: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: iload_0
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc 95
    //   132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 103	com/tencent/thumbplayer/utils/g:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc 110
    //   143: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_2
    //   147: ireturn
    //   148: astore_3
    //   149: ldc 75
    //   151: aload_3
    //   152: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -40 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramInt	int
    //   25	80	1	i	int
    //   23	6	2	j	int
    //   13	50	3	localClass	Class
    //   108	4	3	localClassNotFoundException	ClassNotFoundException
    //   148	4	3	localIllegalAccessException	IllegalAccessException
    //   18	14	4	arrayOfField	Field[]
    //   35	52	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	108	java/lang/ClassNotFoundException
    //   37	81	108	java/lang/ClassNotFoundException
    //   86	94	108	java/lang/ClassNotFoundException
    //   5	24	148	java/lang/IllegalAccessException
    //   37	81	148	java/lang/IllegalAccessException
    //   86	94	148	java/lang/IllegalAccessException
  }
  
  /* Error */
  @com.tencent.thumbplayer.api.TPCommonEnum.TPErrorType
  public static int arc(@com.tencent.thumbplayer.api.TPCommonEnum.NativeErrorType int paramInt)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 121
    //   7: invokevirtual 27	java/lang/Class:getName	()Ljava/lang/String;
    //   10: invokestatic 31	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 35	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   18: astore 4
    //   20: aload 4
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iload_2
    //   28: if_icmpge +87 -> 115
    //   31: aload 4
    //   33: iload_1
    //   34: aaload
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 41	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   42: invokevirtual 44	java/lang/Class:toString	()Ljava/lang/String;
    //   45: ldc 46
    //   47: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +51 -> 101
    //   53: aload 5
    //   55: iconst_1
    //   56: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   59: aload 5
    //   61: ldc 123
    //   63: invokevirtual 66	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   66: checkcast 123	com/tencent/thumbplayer/a/b/b/a$c
    //   69: astore 6
    //   71: aload 6
    //   73: ifnull +28 -> 101
    //   76: iload_0
    //   77: aload 6
    //   79: invokeinterface 124 1 0
    //   84: if_icmpne +17 -> 101
    //   87: aload 5
    //   89: aload_3
    //   90: invokevirtual 60	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   93: istore_1
    //   94: ldc 119
    //   96: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iload_1
    //   100: ireturn
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -79 -> 26
    //   108: astore_3
    //   109: ldc 75
    //   111: aload_3
    //   112: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: ldc 75
    //   117: new 83	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 126
    //   123: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: iload_0
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc 128
    //   132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 103	com/tencent/thumbplayer/utils/g:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc 119
    //   143: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: sipush 1001
    //   149: ireturn
    //   150: astore_3
    //   151: ldc 75
    //   153: aload_3
    //   154: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: goto -42 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramInt	int
    //   25	80	1	i	int
    //   23	6	2	j	int
    //   13	77	3	localClass	Class
    //   108	4	3	localClassNotFoundException	ClassNotFoundException
    //   150	4	3	localIllegalAccessException	IllegalAccessException
    //   18	14	4	arrayOfField	Field[]
    //   35	53	5	localField	Field
    //   69	9	6	localc	a.c
    // Exception table:
    //   from	to	target	type
    //   5	24	108	java/lang/ClassNotFoundException
    //   37	71	108	java/lang/ClassNotFoundException
    //   76	94	108	java/lang/ClassNotFoundException
    //   5	24	150	java/lang/IllegalAccessException
    //   37	71	150	java/lang/IllegalAccessException
    //   76	94	150	java/lang/IllegalAccessException
  }
  
  /* Error */
  @com.tencent.thumbplayer.api.TPCommonEnum.TPMsgInfo
  public static int ard(@com.tencent.thumbplayer.api.TPCommonEnum.NativeMsgInfo int paramInt)
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 134
    //   7: invokevirtual 27	java/lang/Class:getName	()Ljava/lang/String;
    //   10: invokestatic 31	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 35	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   18: astore 4
    //   20: aload 4
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iload_2
    //   28: if_icmpge +87 -> 115
    //   31: aload 4
    //   33: iload_1
    //   34: aaload
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 41	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   42: invokevirtual 44	java/lang/Class:toString	()Ljava/lang/String;
    //   45: ldc 46
    //   47: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +51 -> 101
    //   53: aload 5
    //   55: iconst_1
    //   56: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   59: aload 5
    //   61: ldc 136
    //   63: invokevirtual 66	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   66: checkcast 136	com/tencent/thumbplayer/a/b/b/a$e
    //   69: astore 6
    //   71: aload 6
    //   73: ifnull +28 -> 101
    //   76: iload_0
    //   77: aload 6
    //   79: invokeinterface 137 1 0
    //   84: if_icmpne +17 -> 101
    //   87: aload 5
    //   89: aload_3
    //   90: invokevirtual 60	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   93: istore_1
    //   94: ldc 132
    //   96: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iload_1
    //   100: ireturn
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -79 -> 26
    //   108: astore_3
    //   109: ldc 75
    //   111: aload_3
    //   112: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: ldc 75
    //   117: new 83	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 139
    //   123: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: iload_0
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc 141
    //   132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 103	com/tencent/thumbplayer/utils/g:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc 132
    //   143: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_m1
    //   147: ireturn
    //   148: astore_3
    //   149: ldc 75
    //   151: aload_3
    //   152: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -40 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramInt	int
    //   25	80	1	i	int
    //   23	6	2	j	int
    //   13	77	3	localClass	Class
    //   108	4	3	localClassNotFoundException	ClassNotFoundException
    //   148	4	3	localIllegalAccessException	IllegalAccessException
    //   18	14	4	arrayOfField	Field[]
    //   35	53	5	localField	Field
    //   69	9	6	locale	a.e
    // Exception table:
    //   from	to	target	type
    //   5	24	108	java/lang/ClassNotFoundException
    //   37	71	108	java/lang/ClassNotFoundException
    //   76	94	108	java/lang/ClassNotFoundException
    //   5	24	148	java/lang/IllegalAccessException
    //   37	71	148	java/lang/IllegalAccessException
    //   76	94	148	java/lang/IllegalAccessException
  }
  
  /* Error */
  public static c.a are(@TPCommonEnum.TPOptionalId int paramInt)
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 147
    //   7: invokevirtual 27	java/lang/Class:getName	()Ljava/lang/String;
    //   10: invokestatic 31	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 35	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   18: astore 4
    //   20: aload 4
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iload_2
    //   28: if_icmpge +101 -> 129
    //   31: aload 4
    //   33: iload_1
    //   34: aaload
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 41	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   42: invokevirtual 44	java/lang/Class:toString	()Ljava/lang/String;
    //   45: ldc 46
    //   47: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +65 -> 115
    //   53: aload 5
    //   55: iconst_1
    //   56: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   59: iload_0
    //   60: aload 5
    //   62: aload_3
    //   63: invokevirtual 60	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   66: if_icmpne +49 -> 115
    //   69: aload 5
    //   71: ldc 149
    //   73: invokevirtual 66	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   76: checkcast 149	com/tencent/thumbplayer/a/b/b/a$d
    //   79: astore 5
    //   81: aload 5
    //   83: ifnull +32 -> 115
    //   86: new 151	com/tencent/thumbplayer/a/a/b/c$a
    //   89: dup
    //   90: aload 5
    //   92: invokeinterface 154 1 0
    //   97: aload 5
    //   99: invokeinterface 155 1 0
    //   104: invokespecial 158	com/tencent/thumbplayer/a/a/b/c$a:<init>	(II)V
    //   107: astore_3
    //   108: ldc 145
    //   110: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_3
    //   114: areturn
    //   115: iload_1
    //   116: iconst_1
    //   117: iadd
    //   118: istore_1
    //   119: goto -93 -> 26
    //   122: astore_3
    //   123: ldc 75
    //   125: aload_3
    //   126: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: ldc 75
    //   131: new 83	java/lang/StringBuilder
    //   134: dup
    //   135: ldc 160
    //   137: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: iload_0
    //   141: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc 162
    //   146: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 103	com/tencent/thumbplayer/utils/g:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: ldc 145
    //   157: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_3
    //   163: ldc 75
    //   165: aload_3
    //   166: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: goto -40 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramInt	int
    //   25	94	1	i	int
    //   23	6	2	j	int
    //   13	101	3	localObject1	Object
    //   122	4	3	localClassNotFoundException	ClassNotFoundException
    //   162	4	3	localIllegalAccessException	IllegalAccessException
    //   18	14	4	arrayOfField	Field[]
    //   35	63	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	122	java/lang/ClassNotFoundException
    //   37	81	122	java/lang/ClassNotFoundException
    //   86	108	122	java/lang/ClassNotFoundException
    //   5	24	162	java/lang/IllegalAccessException
    //   37	81	162	java/lang/IllegalAccessException
    //   86	108	162	java/lang/IllegalAccessException
  }
  
  public static c.a arf(@TPCommonEnum.TPOptionalId int paramInt)
  {
    AppMethodBeat.i(189000);
    c.a locala = arg(paramInt);
    if (locala == null)
    {
      locala = arh(paramInt);
      AppMethodBeat.o(189000);
      return locala;
    }
    AppMethodBeat.o(189000);
    return locala;
  }
  
  private static c.a arg(@TPCommonEnum.TPOptionalId int paramInt)
  {
    AppMethodBeat.i(189001);
    try
    {
      c.a locala = g(paramInt, Class.forName(TPOptionalID.class.getName()));
      AppMethodBeat.o(189001);
      return locala;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      g.e("TPNativeKeyMapUtil", localClassNotFoundException);
      AppMethodBeat.o(189001);
    }
    return null;
  }
  
  private static c.a arh(@TPCommonEnum.TPOptionalId int paramInt)
  {
    AppMethodBeat.i(189002);
    try
    {
      c.a locala = g(paramInt, Class.forName(a.class.getName()));
      AppMethodBeat.o(189002);
      return locala;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      g.e("TPNativeKeyMapUtil", localClassNotFoundException);
      AppMethodBeat.o(189002);
    }
    return null;
  }
  
  /* Error */
  public static int ari(int paramInt)
  {
    // Byte code:
    //   0: ldc 180
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 182
    //   7: invokevirtual 27	java/lang/Class:getName	()Ljava/lang/String;
    //   10: invokestatic 31	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 35	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   18: astore 4
    //   20: aload 4
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iload_2
    //   28: if_icmpge +87 -> 115
    //   31: aload 4
    //   33: iload_1
    //   34: aaload
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 41	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   42: invokevirtual 44	java/lang/Class:toString	()Ljava/lang/String;
    //   45: ldc 46
    //   47: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +51 -> 101
    //   53: aload 5
    //   55: iconst_1
    //   56: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   59: iload_0
    //   60: aload 5
    //   62: aload_3
    //   63: invokevirtual 60	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   66: if_icmpne +35 -> 101
    //   69: aload 5
    //   71: ldc 184
    //   73: invokevirtual 66	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   76: checkcast 184	com/tencent/thumbplayer/a/b/b/a$g
    //   79: astore 5
    //   81: aload 5
    //   83: ifnull +18 -> 101
    //   86: aload 5
    //   88: invokeinterface 185 1 0
    //   93: istore_1
    //   94: ldc 180
    //   96: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iload_1
    //   100: ireturn
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -79 -> 26
    //   108: astore_3
    //   109: ldc 75
    //   111: aload_3
    //   112: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: ldc 75
    //   117: new 83	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 187
    //   123: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: iload_0
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc 189
    //   132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 103	com/tencent/thumbplayer/utils/g:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc 180
    //   143: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_m1
    //   147: ireturn
    //   148: astore_3
    //   149: ldc 75
    //   151: aload_3
    //   152: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -40 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramInt	int
    //   25	80	1	i	int
    //   23	6	2	j	int
    //   13	50	3	localClass	Class
    //   108	4	3	localClassNotFoundException	ClassNotFoundException
    //   148	4	3	localIllegalAccessException	IllegalAccessException
    //   18	14	4	arrayOfField	Field[]
    //   35	52	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	108	java/lang/ClassNotFoundException
    //   37	81	108	java/lang/ClassNotFoundException
    //   86	94	108	java/lang/ClassNotFoundException
    //   5	24	148	java/lang/IllegalAccessException
    //   37	81	148	java/lang/IllegalAccessException
    //   86	94	148	java/lang/IllegalAccessException
  }
  
  /* Error */
  public static int arj(int paramInt)
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 193
    //   7: invokevirtual 27	java/lang/Class:getName	()Ljava/lang/String;
    //   10: invokestatic 31	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 35	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   18: astore 4
    //   20: aload 4
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iload_2
    //   28: if_icmpge +87 -> 115
    //   31: aload 4
    //   33: iload_1
    //   34: aaload
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 41	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   42: invokevirtual 44	java/lang/Class:toString	()Ljava/lang/String;
    //   45: ldc 46
    //   47: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +51 -> 101
    //   53: aload 5
    //   55: iconst_1
    //   56: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   59: iload_0
    //   60: aload 5
    //   62: aload_3
    //   63: invokevirtual 60	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   66: if_icmpne +35 -> 101
    //   69: aload 5
    //   71: ldc 195
    //   73: invokevirtual 66	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   76: checkcast 195	com/tencent/thumbplayer/a/b/b/a$a
    //   79: astore 5
    //   81: aload 5
    //   83: ifnull +18 -> 101
    //   86: aload 5
    //   88: invokeinterface 196 1 0
    //   93: istore_1
    //   94: ldc 191
    //   96: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iload_1
    //   100: ireturn
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -79 -> 26
    //   108: astore_3
    //   109: ldc 75
    //   111: aload_3
    //   112: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: ldc 75
    //   117: new 83	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 198
    //   123: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: iload_0
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc 189
    //   132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 103	com/tencent/thumbplayer/utils/g:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc 191
    //   143: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_m1
    //   147: ireturn
    //   148: astore_3
    //   149: ldc 75
    //   151: aload_3
    //   152: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -40 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramInt	int
    //   25	80	1	i	int
    //   23	6	2	j	int
    //   13	50	3	localClass	Class
    //   108	4	3	localClassNotFoundException	ClassNotFoundException
    //   148	4	3	localIllegalAccessException	IllegalAccessException
    //   18	14	4	arrayOfField	Field[]
    //   35	52	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	108	java/lang/ClassNotFoundException
    //   37	81	108	java/lang/ClassNotFoundException
    //   86	94	108	java/lang/ClassNotFoundException
    //   5	24	148	java/lang/IllegalAccessException
    //   37	81	148	java/lang/IllegalAccessException
    //   86	94	148	java/lang/IllegalAccessException
  }
  
  /* Error */
  public static int ark(int paramInt)
  {
    // Byte code:
    //   0: ldc 200
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 193
    //   7: invokevirtual 27	java/lang/Class:getName	()Ljava/lang/String;
    //   10: invokestatic 31	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 35	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   18: astore 4
    //   20: aload 4
    //   22: arraylength
    //   23: istore_2
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: iload_2
    //   28: if_icmpge +87 -> 115
    //   31: aload 4
    //   33: iload_1
    //   34: aaload
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 41	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   42: invokevirtual 44	java/lang/Class:toString	()Ljava/lang/String;
    //   45: ldc 46
    //   47: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +51 -> 101
    //   53: aload 5
    //   55: iconst_1
    //   56: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   59: iload_0
    //   60: aload 5
    //   62: aload_3
    //   63: invokevirtual 60	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   66: if_icmpne +35 -> 101
    //   69: aload 5
    //   71: ldc 202
    //   73: invokevirtual 66	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   76: checkcast 202	com/tencent/thumbplayer/a/b/b/a$b
    //   79: astore 5
    //   81: aload 5
    //   83: ifnull +18 -> 101
    //   86: aload 5
    //   88: invokeinterface 203 1 0
    //   93: istore_1
    //   94: ldc 200
    //   96: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iload_1
    //   100: ireturn
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -79 -> 26
    //   108: astore_3
    //   109: ldc 75
    //   111: aload_3
    //   112: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: ldc 75
    //   117: new 83	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 205
    //   123: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: iload_0
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc 189
    //   132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 103	com/tencent/thumbplayer/utils/g:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc 200
    //   143: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_m1
    //   147: ireturn
    //   148: astore_3
    //   149: ldc 75
    //   151: aload_3
    //   152: invokestatic 81	com/tencent/thumbplayer/utils/g:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -40 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramInt	int
    //   25	80	1	i	int
    //   23	6	2	j	int
    //   13	50	3	localClass	Class
    //   108	4	3	localClassNotFoundException	ClassNotFoundException
    //   148	4	3	localIllegalAccessException	IllegalAccessException
    //   18	14	4	arrayOfField	Field[]
    //   35	52	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	24	108	java/lang/ClassNotFoundException
    //   37	81	108	java/lang/ClassNotFoundException
    //   86	94	108	java/lang/ClassNotFoundException
    //   5	24	148	java/lang/IllegalAccessException
    //   37	81	148	java/lang/IllegalAccessException
    //   86	94	148	java/lang/IllegalAccessException
  }
  
  private static c.a g(@TPCommonEnum.TPOptionalId int paramInt, Class paramClass)
  {
    AppMethodBeat.i(189003);
    try
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfField[i];
        if (((Field)localObject).getType().toString().equals("int"))
        {
          ((Field)localObject).setAccessible(true);
          if (paramInt == ((Field)localObject).getInt(paramClass))
          {
            localObject = (a.f)((Field)localObject).getAnnotation(a.f.class);
            if (localObject != null)
            {
              paramClass = new c.a(((a.f)localObject).type(), ((a.f)localObject).value());
              AppMethodBeat.o(189003);
              return paramClass;
            }
          }
        }
        i += 1;
      }
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      g.e("TPNativeKeyMapUtil", paramClass);
      g.w("TPNativeKeyMapUtil", "convertToNativeOptionalIdInternal, tpOptionalId: " + paramInt + " not recognition, return null");
      AppMethodBeat.o(189003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */