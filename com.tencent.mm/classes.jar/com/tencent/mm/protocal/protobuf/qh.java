package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import f.a.a.b;
import java.util.LinkedList;

public final class qh
  extends cvp
{
  public c CZq;
  public long CZs;
  public long FMa;
  public LinkedList<String> FMb;
  public int FMc;
  public int FMd;
  public String FMe;
  public String FMf;
  public String FMg;
  public boolean FMh;
  public int ozR;
  public String ozS;
  
  public qh()
  {
    AppMethodBeat.i(91377);
    this.FMb = new LinkedList();
    AppMethodBeat.o(91377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91378);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91378);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.aY(4, this.CZs);
      if (this.CZq != null)
      {
        paramVarArgs.lC(5, this.CZq.computeSize());
        this.CZq.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.FMa);
      paramVarArgs.e(7, 1, this.FMb);
      paramVarArgs.aS(8, this.FMc);
      paramVarArgs.aS(9, this.FMd);
      if (this.FMe != null) {
        paramVarArgs.d(10, this.FMe);
      }
      if (this.FMf != null) {
        paramVarArgs.d(11, this.FMf);
      }
      if (this.FMg != null) {
        paramVarArgs.d(12, this.FMg);
      }
      paramVarArgs.bt(13, this.FMh);
      AppMethodBeat.o(91378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1082;
      }
    }
    label1082:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.CZs);
      paramInt = i;
      if (this.CZq != null) {
        paramInt = i + f.a.a.a.lB(5, this.CZq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.FMa) + f.a.a.a.c(7, 1, this.FMb) + f.a.a.b.b.a.bz(8, this.FMc) + f.a.a.b.b.a.bz(9, this.FMd);
      paramInt = i;
      if (this.FMe != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FMe);
      }
      i = paramInt;
      if (this.FMf != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FMf);
      }
      paramInt = i;
      if (this.FMg != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FMg);
      }
      i = f.a.a.b.b.a.alV(13);
      AppMethodBeat.o(91378);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FMb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91378);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qh localqh = (qh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91378);
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
            localqh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 2: 
          localqh.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91378);
          return 0;
        case 3: 
          localqh.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 4: 
          localqh.CZs = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91378);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqh.CZq = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 6: 
          localqh.FMa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91378);
          return 0;
        case 7: 
          localqh.FMb.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(91378);
          return 0;
        case 8: 
          localqh.FMc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91378);
          return 0;
        case 9: 
          localqh.FMd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91378);
          return 0;
        case 10: 
          localqh.FMe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 11: 
          localqh.FMf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 12: 
          localqh.FMg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91378);
          return 0;
        }
        localqh.FMh = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(91378);
        return 0;
      }
      AppMethodBeat.o(91378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qh
 * JD-Core Version:    0.7.0.1
 */