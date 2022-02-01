package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejt
  extends dop
{
  public String Cru;
  public String Njb;
  public String Njc;
  public String Njd;
  public String Nje;
  public int bDZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72590);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.bDZ);
      if (this.Njb != null) {
        paramVarArgs.e(3, this.Njb);
      }
      if (this.Njc != null) {
        paramVarArgs.e(4, this.Njc);
      }
      if (this.Cru != null) {
        paramVarArgs.e(5, this.Cru);
      }
      if (this.Njd != null) {
        paramVarArgs.e(6, this.Njd);
      }
      if (this.Nje != null) {
        paramVarArgs.e(7, this.Nje);
      }
      AppMethodBeat.o(72590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.bDZ);
      paramInt = i;
      if (this.Njb != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Njb);
      }
      i = paramInt;
      if (this.Njc != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Njc);
      }
      paramInt = i;
      if (this.Cru != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Cru);
      }
      i = paramInt;
      if (this.Njd != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Njd);
      }
      paramInt = i;
      if (this.Nje != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Nje);
      }
      AppMethodBeat.o(72590);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ejt localejt = (ejt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72590);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localejt.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72590);
          return 0;
        case 2: 
          localejt.bDZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72590);
          return 0;
        case 3: 
          localejt.Njb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 4: 
          localejt.Njc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 5: 
          localejt.Cru = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 6: 
          localejt.Njd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72590);
          return 0;
        }
        localejt.Nje = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72590);
        return 0;
      }
      AppMethodBeat.o(72590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejt
 * JD-Core Version:    0.7.0.1
 */