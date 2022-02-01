package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eek
  extends cvp
{
  public int FMu;
  public String GDb;
  public int HPG;
  public crl HPH;
  public crj HPI;
  public int HPJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HPG);
      paramVarArgs.aS(3, this.FMu);
      if (this.GDb != null) {
        paramVarArgs.d(4, this.GDb);
      }
      if (this.HPH != null)
      {
        paramVarArgs.lC(5, this.HPH.computeSize());
        this.HPH.writeFields(paramVarArgs);
      }
      if (this.HPI != null)
      {
        paramVarArgs.lC(6, this.HPI.computeSize());
        this.HPI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.HPJ);
      AppMethodBeat.o(117949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HPG) + f.a.a.b.b.a.bz(3, this.FMu);
      paramInt = i;
      if (this.GDb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GDb);
      }
      i = paramInt;
      if (this.HPH != null) {
        i = paramInt + f.a.a.a.lB(5, this.HPH.computeSize());
      }
      paramInt = i;
      if (this.HPI != null) {
        paramInt = i + f.a.a.a.lB(6, this.HPI.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.HPJ);
      AppMethodBeat.o(117949);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eek localeek = (eek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117949);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeek.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 2: 
          localeek.HPG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117949);
          return 0;
        case 3: 
          localeek.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117949);
          return 0;
        case 4: 
          localeek.GDb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117949);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeek.HPH = ((crl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeek.HPI = ((crj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        }
        localeek.HPJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117949);
        return 0;
      }
      AppMethodBeat.o(117949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eek
 * JD-Core Version:    0.7.0.1
 */