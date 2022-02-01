package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nz
  extends ckq
{
  public String CIt;
  public bmo CLC;
  public cmr CLD;
  public int Ctl;
  public String Ctm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CIt != null) {
        paramVarArgs.d(2, this.CIt);
      }
      if (this.CLC != null)
      {
        paramVarArgs.kX(3, this.CLC.computeSize());
        this.CLC.writeFields(paramVarArgs);
      }
      if (this.CLD != null)
      {
        paramVarArgs.kX(4, this.CLD.computeSize());
        this.CLD.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.Ctl);
      if (this.Ctm != null) {
        paramVarArgs.d(6, this.Ctm);
      }
      AppMethodBeat.o(32149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CIt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CIt);
      }
      i = paramInt;
      if (this.CLC != null) {
        i = paramInt + f.a.a.a.kW(3, this.CLC.computeSize());
      }
      paramInt = i;
      if (this.CLD != null) {
        paramInt = i + f.a.a.a.kW(4, this.CLD.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.Ctl);
      paramInt = i;
      if (this.Ctm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ctm);
      }
      AppMethodBeat.o(32149);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32149);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nz localnz = (nz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32149);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 2: 
          localnz.CIt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32149);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnz.CLC = ((bmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnz.CLD = ((cmr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 5: 
          localnz.Ctl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32149);
          return 0;
        }
        localnz.Ctm = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32149);
        return 0;
      }
      AppMethodBeat.o(32149);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nz
 * JD-Core Version:    0.7.0.1
 */