package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alm
  extends cld
{
  public SKBuiltinBuffer_t DmH;
  public LinkedList<FinderContact> DmI;
  public xe DmJ;
  public int DmK;
  public LinkedList<FinderContact> Dmo;
  public int continueFlag;
  public LinkedList<ahv> pJl;
  
  public alm()
  {
    AppMethodBeat.i(169062);
    this.DmI = new LinkedList();
    this.Dmo = new LinkedList();
    this.pJl = new LinkedList();
    AppMethodBeat.o(169062);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169063);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DmJ != null)
      {
        paramVarArgs.kX(2, this.DmJ.computeSize());
        this.DmJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.continueFlag);
      if (this.DmH != null)
      {
        paramVarArgs.kX(4, this.DmH.computeSize());
        this.DmH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.DmI);
      paramVarArgs.e(6, 8, this.Dmo);
      paramVarArgs.e(7, 8, this.pJl);
      paramVarArgs.aR(8, this.DmK);
      AppMethodBeat.o(169063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1138;
      }
    }
    label1138:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DmJ != null) {
        i = paramInt + f.a.a.a.kW(2, this.DmJ.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.continueFlag);
      paramInt = i;
      if (this.DmH != null) {
        paramInt = i + f.a.a.a.kW(4, this.DmH.computeSize());
      }
      i = f.a.a.a.c(5, 8, this.DmI);
      int j = f.a.a.a.c(6, 8, this.Dmo);
      int k = f.a.a.a.c(7, 8, this.pJl);
      int m = f.a.a.b.b.a.bA(8, this.DmK);
      AppMethodBeat.o(169063);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DmI.clear();
        this.Dmo.clear();
        this.pJl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169063);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alm localalm = (alm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169063);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalm.DmJ = ((xe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 3: 
          localalm.continueFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169063);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalm.DmH = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalm.DmI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalm.Dmo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalm.pJl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169063);
          return 0;
        }
        localalm.DmK = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169063);
        return 0;
      }
      AppMethodBeat.o(169063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alm
 * JD-Core Version:    0.7.0.1
 */