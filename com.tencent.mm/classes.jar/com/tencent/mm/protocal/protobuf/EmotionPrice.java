package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class EmotionPrice
  extends com.tencent.mm.bw.a
{
  public String IapProductId;
  public String Label;
  public String Number;
  public String Type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104779);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Label == null)
      {
        paramVarArgs = new b("Not all required fields were included: Label");
        AppMethodBeat.o(104779);
        throw paramVarArgs;
      }
      if (this.Number == null)
      {
        paramVarArgs = new b("Not all required fields were included: Number");
        AppMethodBeat.o(104779);
        throw paramVarArgs;
      }
      if (this.Type == null)
      {
        paramVarArgs = new b("Not all required fields were included: Type");
        AppMethodBeat.o(104779);
        throw paramVarArgs;
      }
      if (this.Label != null) {
        paramVarArgs.e(1, this.Label);
      }
      if (this.Number != null) {
        paramVarArgs.e(2, this.Number);
      }
      if (this.Type != null) {
        paramVarArgs.e(3, this.Type);
      }
      if (this.IapProductId != null) {
        paramVarArgs.e(4, this.IapProductId);
      }
      AppMethodBeat.o(104779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Label == null) {
        break label538;
      }
    }
    label538:
    for (int i = g.a.a.b.b.a.f(1, this.Label) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Number != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Number);
      }
      i = paramInt;
      if (this.Type != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Type);
      }
      paramInt = i;
      if (this.IapProductId != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.IapProductId);
      }
      AppMethodBeat.o(104779);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Label == null)
        {
          paramVarArgs = new b("Not all required fields were included: Label");
          AppMethodBeat.o(104779);
          throw paramVarArgs;
        }
        if (this.Number == null)
        {
          paramVarArgs = new b("Not all required fields were included: Number");
          AppMethodBeat.o(104779);
          throw paramVarArgs;
        }
        if (this.Type == null)
        {
          paramVarArgs = new b("Not all required fields were included: Type");
          AppMethodBeat.o(104779);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104779);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        EmotionPrice localEmotionPrice = (EmotionPrice)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104779);
          return -1;
        case 1: 
          localEmotionPrice.Label = locala.UbS.readString();
          AppMethodBeat.o(104779);
          return 0;
        case 2: 
          localEmotionPrice.Number = locala.UbS.readString();
          AppMethodBeat.o(104779);
          return 0;
        case 3: 
          localEmotionPrice.Type = locala.UbS.readString();
          AppMethodBeat.o(104779);
          return 0;
        }
        localEmotionPrice.IapProductId = locala.UbS.readString();
        AppMethodBeat.o(104779);
        return 0;
      }
      AppMethodBeat.o(104779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionPrice
 * JD-Core Version:    0.7.0.1
 */