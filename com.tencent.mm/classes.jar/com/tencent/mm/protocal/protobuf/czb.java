package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czb
  extends cvp
{
  public LinkedList<ehy> Fys;
  public boolean GAQ;
  public int HfH;
  public int Hmw;
  public ehp HpN;
  public int HpO;
  public com.tencent.mm.bx.b HpP;
  public String HpQ;
  public String Title;
  public int nDI;
  public int nDi;
  public int nEf;
  public int qel;
  
  public czb()
  {
    AppMethodBeat.i(117922);
    this.Fys = new LinkedList();
    AppMethodBeat.o(117922);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117923);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(117923);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nDI);
      paramVarArgs.aS(3, this.nEf);
      paramVarArgs.aS(4, this.HfH);
      paramVarArgs.aS(5, this.nDi);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      if (this.HpN != null)
      {
        paramVarArgs.lC(7, this.HpN.computeSize());
        this.HpN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.Fys);
      paramVarArgs.aS(9, this.Hmw);
      paramVarArgs.aS(10, this.HpO);
      paramVarArgs.bt(11, this.GAQ);
      if (this.HpP != null) {
        paramVarArgs.c(12, this.HpP);
      }
      paramVarArgs.aS(13, this.qel);
      if (this.HpQ != null) {
        paramVarArgs.d(14, this.HpQ);
      }
      AppMethodBeat.o(117923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nDI) + f.a.a.b.b.a.bz(3, this.nEf) + f.a.a.b.b.a.bz(4, this.HfH) + f.a.a.b.b.a.bz(5, this.nDi);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      i = paramInt;
      if (this.HpN != null) {
        i = paramInt + f.a.a.a.lB(7, this.HpN.computeSize());
      }
      i = i + f.a.a.a.c(8, 8, this.Fys) + f.a.a.b.b.a.bz(9, this.Hmw) + f.a.a.b.b.a.bz(10, this.HpO) + f.a.a.b.b.a.alV(11);
      paramInt = i;
      if (this.HpP != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.HpP);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.qel);
      paramInt = i;
      if (this.HpQ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HpQ);
      }
      AppMethodBeat.o(117923);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fys.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(117923);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117923);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czb localczb = (czb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117923);
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
            localczb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 2: 
          localczb.nDI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 3: 
          localczb.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 4: 
          localczb.HfH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 5: 
          localczb.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 6: 
          localczb.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117923);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczb.HpN = ((ehp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczb.Fys.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117923);
          return 0;
        case 9: 
          localczb.Hmw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 10: 
          localczb.HpO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117923);
          return 0;
        case 11: 
          localczb.GAQ = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(117923);
          return 0;
        case 12: 
          localczb.HpP = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(117923);
          return 0;
        case 13: 
          localczb.qel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117923);
          return 0;
        }
        localczb.HpQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117923);
        return 0;
      }
      AppMethodBeat.o(117923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czb
 * JD-Core Version:    0.7.0.1
 */