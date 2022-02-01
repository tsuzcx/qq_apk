package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dln
  extends ckq
{
  public int CCe;
  public long DYU;
  public int DYV;
  public long Dea;
  public String EBF;
  public long Erf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DYV);
      paramVarArgs.aG(3, this.Erf);
      paramVarArgs.aG(4, this.Dea);
      if (this.EBF != null) {
        paramVarArgs.d(5, this.EBF);
      }
      paramVarArgs.aG(6, this.DYU);
      paramVarArgs.aR(7, this.CCe);
      AppMethodBeat.o(125494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DYV) + f.a.a.b.b.a.q(3, this.Erf) + f.a.a.b.b.a.q(4, this.Dea);
      paramInt = i;
      if (this.EBF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EBF);
      }
      i = f.a.a.b.b.a.q(6, this.DYU);
      int j = f.a.a.b.b.a.bA(7, this.CCe);
      AppMethodBeat.o(125494);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dln localdln = (dln)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125494);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdln.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125494);
          return 0;
        case 2: 
          localdln.DYV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125494);
          return 0;
        case 3: 
          localdln.Erf = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125494);
          return 0;
        case 4: 
          localdln.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125494);
          return 0;
        case 5: 
          localdln.EBF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125494);
          return 0;
        case 6: 
          localdln.DYU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125494);
          return 0;
        }
        localdln.CCe = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125494);
        return 0;
      }
      AppMethodBeat.o(125494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dln
 * JD-Core Version:    0.7.0.1
 */