package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlg
  extends cld
{
  public int DdZ;
  public long Dea;
  public int EAT;
  public int EBc;
  public dmv EBd;
  public int EBe;
  public int EBf;
  public int EBg;
  public int EBh;
  public SKBuiltinBuffer_t EBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115859);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aG(3, this.Dea);
      paramVarArgs.aR(4, this.EBc);
      if (this.EBd != null)
      {
        paramVarArgs.kX(5, this.EBd.computeSize());
        this.EBd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.EAT);
      paramVarArgs.aR(7, this.EBe);
      paramVarArgs.aR(8, this.EBf);
      paramVarArgs.aR(9, this.EBg);
      paramVarArgs.aR(10, this.EBh);
      if (this.EBi != null)
      {
        paramVarArgs.kX(11, this.EBi.computeSize());
        this.EBi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DdZ) + f.a.a.b.b.a.q(3, this.Dea) + f.a.a.b.b.a.bA(4, this.EBc);
      paramInt = i;
      if (this.EBd != null) {
        paramInt = i + f.a.a.a.kW(5, this.EBd.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.EAT) + f.a.a.b.b.a.bA(7, this.EBe) + f.a.a.b.b.a.bA(8, this.EBf) + f.a.a.b.b.a.bA(9, this.EBg) + f.a.a.b.b.a.bA(10, this.EBh);
      paramInt = i;
      if (this.EBi != null) {
        paramInt = i + f.a.a.a.kW(11, this.EBi.computeSize());
      }
      AppMethodBeat.o(115859);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlg localdlg = (dlg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115859);
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
            localdlg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 2: 
          localdlg.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115859);
          return 0;
        case 3: 
          localdlg.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115859);
          return 0;
        case 4: 
          localdlg.EBc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115859);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlg.EBd = ((dmv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 6: 
          localdlg.EAT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115859);
          return 0;
        case 7: 
          localdlg.EBe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115859);
          return 0;
        case 8: 
          localdlg.EBf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115859);
          return 0;
        case 9: 
          localdlg.EBg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115859);
          return 0;
        case 10: 
          localdlg.EBh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115859);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlg.EBi = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      AppMethodBeat.o(115859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlg
 * JD-Core Version:    0.7.0.1
 */