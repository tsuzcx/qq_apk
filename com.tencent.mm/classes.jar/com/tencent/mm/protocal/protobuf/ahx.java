package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahx
  extends dop
{
  public int Brl;
  public long Brn;
  public String KGO;
  public String KIz;
  public int KUy;
  public int KZk;
  public long LrE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148652);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Brl);
      paramVarArgs.aM(2, this.KZk);
      paramVarArgs.aM(3, this.KUy);
      if (this.KIz != null) {
        paramVarArgs.e(4, this.KIz);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(5, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.Brn);
      if (this.KGO != null) {
        paramVarArgs.e(7, this.KGO);
      }
      paramVarArgs.bb(8, this.LrE);
      AppMethodBeat.o(148652);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Brl) + 0 + g.a.a.b.b.a.bu(2, this.KZk) + g.a.a.b.b.a.bu(3, this.KUy);
      paramInt = i;
      if (this.KIz != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KIz);
      }
      i = paramInt;
      if (this.BaseRequest != null) {
        i = paramInt + g.a.a.a.nh(5, this.BaseRequest.computeSize());
      }
      i += g.a.a.b.b.a.r(6, this.Brn);
      paramInt = i;
      if (this.KGO != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KGO);
      }
      i = g.a.a.b.b.a.r(8, this.LrE);
      AppMethodBeat.o(148652);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(148652);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ahx localahx = (ahx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(148652);
        return -1;
      case 1: 
        localahx.Brl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148652);
        return 0;
      case 2: 
        localahx.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148652);
        return 0;
      case 3: 
        localahx.KUy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(148652);
        return 0;
      case 4: 
        localahx.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(148652);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahx.BaseRequest = ((jr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148652);
        return 0;
      case 6: 
        localahx.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(148652);
        return 0;
      case 7: 
        localahx.KGO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(148652);
        return 0;
      }
      localahx.LrE = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(148652);
      return 0;
    }
    AppMethodBeat.o(148652);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahx
 * JD-Core Version:    0.7.0.1
 */