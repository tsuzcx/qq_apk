package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class g
{
  public int NKf = 0;
  
  private static byte[] I(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(114847);
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new j(paramInputStream, (OutputStream)localObject);
    paramInputStream.akG(8);
    paramInputStream.akG(8);
    paramInputStream.akG(8);
    paramInputStream.akG(8);
    paramInputStream.akG(8);
    int i = (int)paramInputStream.gyu();
    paramInputStream.akG(8);
    paramInputStream.gyu();
    paramInputStream.gyy();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.gyx() == 3) {
        paramInputStream.akG(1);
      }
      paramInputStream.gyy();
      paramInputStream.gyy();
      paramInputStream.akG(1);
      if (paramInputStream.AQ(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.AQ(true))
          {
            if (i >= 6) {
              break label172;
            }
            paramInputStream.akH(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label172:
            paramInputStream.akH(64);
          }
        }
      }
    }
    paramInputStream.gyy();
    i = paramInputStream.gyx();
    if (i == 0)
    {
      paramInputStream.gyy();
      paramInputStream.gyy();
      paramInputStream.akG(1);
      paramInputStream.gyy();
      paramInputStream.gyy();
      if (!paramInputStream.AQ(true)) {
        paramInputStream.akG(1);
      }
      paramInputStream.akG(1);
      if (paramInputStream.AQ(true))
      {
        paramInputStream.gyy();
        paramInputStream.gyy();
        paramInputStream.gyy();
        paramInputStream.gyy();
      }
      if (!paramInputStream.AQ(false)) {
        break label731;
      }
      Log.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      paramInputStream.AS(true);
      if ((paramInputStream.AQ(true)) && ((int)paramInputStream.gyu() == 255))
      {
        paramInputStream.akG(16);
        paramInputStream.akG(16);
      }
      if (paramInputStream.AQ(true)) {
        paramInputStream.akG(1);
      }
      if (paramInputStream.AQ(true))
      {
        paramInputStream.akG(3);
        paramInputStream.akG(1);
        if (paramInputStream.AQ(true))
        {
          paramInputStream.akG(8);
          paramInputStream.akG(8);
          paramInputStream.akG(8);
        }
      }
      if (paramInputStream.AQ(true))
      {
        paramInputStream.gyy();
        paramInputStream.gyy();
      }
      if (paramInputStream.AQ(true))
      {
        paramInputStream.akG(32);
        paramInputStream.akG(32);
        paramInputStream.akG(1);
      }
      boolean bool1 = paramInputStream.AQ(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.AQ(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.akG(1);
      }
      paramInputStream.akG(1);
      if (!paramInputStream.AQ(false)) {
        break label679;
      }
      Log.d("TAG", "steve:VUI has bs restriction!!");
      paramInputStream.AS(true);
      paramInputStream.AQ(true);
      paramInputStream.gyy();
      paramInputStream.gyy();
      paramInputStream.gyy();
      paramInputStream.gyy();
      paramInputStream.gyy();
      paramInputStream.akK(1);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      paramInputStream.akI(1);
      paramInputStream.ar(0L, 8 - paramInputStream.NLC);
      paramInputStream.flush();
      arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      paramInputStream = "";
      i = j;
      while (i < arrayOfByte.length)
      {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject = str;
        if (str.length() == 1) {
          localObject = "0".concat(String.valueOf(str));
        }
        paramInputStream = paramInputStream + " " + (String)localObject;
        i += 1;
      }
      if (i != 1) {
        break;
      }
      paramInputStream.akG(1);
      paramInputStream.gyy();
      paramInputStream.gyy();
      int k = paramInputStream.gyx();
      i = 0;
      while (i < k)
      {
        new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
        paramInputStream.gyy();
        i += 1;
      }
      break;
      label679:
      Log.d("TAG", "steve:VUI has NO bs restriction!!");
      paramInputStream.AS(true);
      paramInputStream.AS(true);
      paramInputStream.akK(0);
      paramInputStream.akK(0);
      paramInputStream.akK(10);
      paramInputStream.akK(10);
      paramInputStream.akK(0);
      paramInputStream.akK(1);
      continue;
      label731:
      Log.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      paramInputStream.AS(true);
      paramInputStream.AS(false);
      paramInputStream.AS(false);
      paramInputStream.AS(false);
      paramInputStream.AS(false);
      paramInputStream.AS(false);
      paramInputStream.AS(false);
      paramInputStream.AS(false);
      paramInputStream.AS(false);
      paramInputStream.AS(true);
      paramInputStream.AS(true);
      paramInputStream.akK(0);
      paramInputStream.akK(0);
      paramInputStream.akK(10);
      paramInputStream.akK(10);
      paramInputStream.akK(0);
      paramInputStream.akK(1);
    }
    Log.d("TAG", "new SPS:".concat(String.valueOf(paramInputStream)));
    AppMethodBeat.o(114847);
    return arrayOfByte;
  }
  
  private boolean J(InputStream paramInputStream)
  {
    AppMethodBeat.i(114849);
    paramInputStream = new j(paramInputStream);
    paramInputStream.akF(8);
    paramInputStream.akF(8);
    paramInputStream.akF(8);
    paramInputStream.akF(8);
    paramInputStream.akF(8);
    int i = (int)paramInputStream.gyu();
    if (i == 66)
    {
      this.NKf |= 0x1;
      AppMethodBeat.o(114849);
      return false;
    }
    paramInputStream.akF(8);
    paramInputStream.gyu();
    paramInputStream.gyw();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.gyx() == 3) {
        paramInputStream.akF(1);
      }
      paramInputStream.gyw();
      paramInputStream.gyw();
      paramInputStream.akF(1);
      if (paramInputStream.AQ(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.AQ(true))
          {
            if (i >= 6) {
              break label182;
            }
            paramInputStream.akH(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label182:
            paramInputStream.akH(64);
          }
        }
      }
    }
    paramInputStream.gyw();
    i = paramInputStream.gyx();
    if (i == 0) {
      paramInputStream.gyw();
    }
    for (;;)
    {
      if (paramInputStream.gyx() >= 2) {
        this.NKf |= 0x2;
      }
      paramInputStream.akG(1);
      paramInputStream.gyy();
      paramInputStream.gyy();
      if (!paramInputStream.AQ(true)) {
        paramInputStream.akG(1);
      }
      paramInputStream.akG(1);
      if (paramInputStream.AQ(true))
      {
        paramInputStream.gyy();
        paramInputStream.gyy();
        paramInputStream.gyy();
        paramInputStream.gyy();
      }
      if (!paramInputStream.AQ(true)) {
        break;
      }
      Log.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
      if ((paramInputStream.AQ(true)) && ((int)paramInputStream.gyu() == 255))
      {
        paramInputStream.akG(16);
        paramInputStream.akG(16);
      }
      if (paramInputStream.AQ(true)) {
        paramInputStream.akG(1);
      }
      if (paramInputStream.AQ(true))
      {
        paramInputStream.akG(3);
        paramInputStream.akG(1);
        if (paramInputStream.AQ(true))
        {
          paramInputStream.akG(8);
          paramInputStream.akG(8);
          paramInputStream.akG(8);
        }
      }
      if (paramInputStream.AQ(true))
      {
        paramInputStream.gyy();
        paramInputStream.gyy();
      }
      if (paramInputStream.AQ(true))
      {
        paramInputStream.akG(32);
        paramInputStream.akG(32);
        paramInputStream.akG(1);
      }
      boolean bool1 = paramInputStream.AQ(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.AQ(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.akG(1);
      }
      paramInputStream.akG(1);
      if (!paramInputStream.AQ(true)) {
        break;
      }
      paramInputStream.AQ(true);
      paramInputStream.gyy();
      paramInputStream.gyy();
      paramInputStream.gyy();
      paramInputStream.gyy();
      i = paramInputStream.gyx();
      int j = paramInputStream.gyx();
      if (i == 0) {
        break;
      }
      Log.d("[H264SPSModifier]", "steve: reorder_frame =" + i + ", mac_dec_buffering=" + j);
      this.NKf |= 0x4;
      AppMethodBeat.o(114849);
      return true;
      if (i == 1)
      {
        paramInputStream.akF(1);
        paramInputStream.gyw();
        paramInputStream.gyw();
        j = paramInputStream.gyx();
        i = 0;
        while (i < j)
        {
          new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
          paramInputStream.gyy();
          i += 1;
        }
      }
    }
    AppMethodBeat.o(114849);
    return false;
  }
  
  private boolean K(InputStream paramInputStream)
  {
    AppMethodBeat.i(114851);
    paramInputStream = new j(paramInputStream);
    paramInputStream.akF(8);
    paramInputStream.akF(8);
    paramInputStream.akF(8);
    paramInputStream.akF(8);
    paramInputStream.akF(8);
    paramInputStream.gyw();
    int i = paramInputStream.gyx();
    Log.d("TAG", "steve:slice_type:".concat(String.valueOf(i)));
    if ((i == 1) || (i == 6))
    {
      this.NKf |= 0x8;
      AppMethodBeat.o(114851);
      return true;
    }
    AppMethodBeat.o(114851);
    return false;
  }
  
  private static void a(j paramj)
  {
    AppMethodBeat.i(114852);
    int j = paramj.gyx();
    paramj.akF(4);
    paramj.akF(4);
    int i = 0;
    while (i <= j)
    {
      paramj.gyw();
      paramj.gyw();
      paramj.akF(1);
      i += 1;
    }
    paramj.akF(5);
    paramj.akF(5);
    paramj.akF(5);
    paramj.akF(5);
    AppMethodBeat.o(114852);
  }
  
  public final byte[] cv(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(236203);
    paramArrayOfByte = I(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(236203);
    return paramArrayOfByte;
  }
  
  public final boolean cw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114848);
    boolean bool = J(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114848);
    return bool;
  }
  
  public final boolean cx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114850);
    boolean bool = K(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114850);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.g
 * JD-Core Version:    0.7.0.1
 */