package com.tencent.mm.plugin.normsg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class c
{
  public static String TN(int paramInt)
  {
    AppMethodBeat.i(192286);
    Object localObject = new StringBuilder();
    switch (paramInt)
    {
    default: 
      ((StringBuilder)localObject).append("Unknown");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(UUID.randomUUID().toString());
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(192286);
      return localObject;
      ((StringBuilder)localObject).append("VerifyUser");
      continue;
      ((StringBuilder)localObject).append("Login");
      continue;
      ((StringBuilder)localObject).append("Register");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.c
 * JD-Core Version:    0.7.0.1
 */