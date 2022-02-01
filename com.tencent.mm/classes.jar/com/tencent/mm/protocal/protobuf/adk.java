package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class adk
  extends cld
{
  public int CCF;
  public LinkedList<dbe> CCG;
  public LinkedList<dbf> Cxd;
  public int DdZ;
  public long Dea;
  public int Deb;
  public int Dec;
  public int Ded;
  
  public adk()
  {
    AppMethodBeat.i(32191);
    this.Cxd = new LinkedList();
    this.CCG = new LinkedList();
    AppMethodBeat.o(32191);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32192);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32192);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aG(3, this.Dea);
      paramVarArgs.aR(4, this.Deb);
      paramVarArgs.aR(5, this.Dec);
      paramVarArgs.e(6, 8, this.Cxd);
      paramVarArgs.aR(7, this.Ded);
      paramVarArgs.aR(8, this.CCF);
      paramVarArgs.e(9, 8, this.CCG);
      AppMethodBeat.o(32192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DdZ);
      int j = f.a.a.b.b.a.q(3, this.Dea);
      int k = f.a.a.b.b.a.bA(4, this.Deb);
      int m = f.a.a.b.b.a.bA(5, this.Dec);
      int n = f.a.a.a.c(6, 8, this.Cxd);
      int i1 = f.a.a.b.b.a.bA(7, this.Ded);
      int i2 = f.a.a.b.b.a.bA(8, this.CCF);
      int i3 = f.a.a.a.c(9, 8, this.CCG);
      AppMethodBeat.o(32192);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Cxd.clear();
        this.CCG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32192);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adk localadk = (adk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32192);
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
            localadk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 2: 
          localadk.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32192);
          return 0;
        case 3: 
          localadk.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32192);
          return 0;
        case 4: 
          localadk.Deb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32192);
          return 0;
        case 5: 
          localadk.Dec = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32192);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadk.Cxd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32192);
          return 0;
        case 7: 
          localadk.Ded = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32192);
          return 0;
        case 8: 
          localadk.CCF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32192);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadk.CCG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32192);
        return 0;
      }
      AppMethodBeat.o(32192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adk
 * JD-Core Version:    0.7.0.1
 */