package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class us
  extends cvp
{
  public String CTa;
  public cra FTQ;
  public boolean FUh;
  public String FUi;
  public int FUj;
  public LinkedList<Integer> FUk;
  public String FUl;
  public int FUm;
  public int FUn;
  public String desc;
  public int dlw;
  public String nZO;
  public String ozC;
  public String paA;
  public String xXy;
  
  public us()
  {
    AppMethodBeat.i(72433);
    this.FUk = new LinkedList();
    AppMethodBeat.o(72433);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72434);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      paramVarArgs.bt(4, this.FUh);
      if (this.xXy != null) {
        paramVarArgs.d(5, this.xXy);
      }
      if (this.FUi != null) {
        paramVarArgs.d(6, this.FUi);
      }
      if (this.nZO != null) {
        paramVarArgs.d(7, this.nZO);
      }
      paramVarArgs.aS(8, this.FUj);
      if (this.desc != null) {
        paramVarArgs.d(9, this.desc);
      }
      if (this.CTa != null) {
        paramVarArgs.d(10, this.CTa);
      }
      paramVarArgs.e(11, 2, this.FUk);
      if (this.FUl != null) {
        paramVarArgs.d(12, this.FUl);
      }
      if (this.ozC != null) {
        paramVarArgs.d(13, this.ozC);
      }
      paramVarArgs.aS(14, this.FUm);
      paramVarArgs.aS(15, this.FUn);
      if (this.FTQ != null)
      {
        paramVarArgs.lC(16, this.FTQ.computeSize());
        this.FTQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1289;
      }
    }
    label1289:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt + f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.xXy != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.xXy);
      }
      i = paramInt;
      if (this.FUi != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FUi);
      }
      paramInt = i;
      if (this.nZO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nZO);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FUj);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.desc);
      }
      i = paramInt;
      if (this.CTa != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CTa);
      }
      i += f.a.a.a.c(11, 2, this.FUk);
      paramInt = i;
      if (this.FUl != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FUl);
      }
      i = paramInt;
      if (this.ozC != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ozC);
      }
      i = i + f.a.a.b.b.a.bz(14, this.FUm) + f.a.a.b.b.a.bz(15, this.FUn);
      paramInt = i;
      if (this.FTQ != null) {
        paramInt = i + f.a.a.a.lB(16, this.FTQ.computeSize());
      }
      AppMethodBeat.o(72434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72434);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        us localus = (us)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72434);
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
            localus.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72434);
          return 0;
        case 2: 
          localus.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72434);
          return 0;
        case 3: 
          localus.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 4: 
          localus.FUh = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72434);
          return 0;
        case 5: 
          localus.xXy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 6: 
          localus.FUi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 7: 
          localus.nZO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 8: 
          localus.FUj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72434);
          return 0;
        case 9: 
          localus.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 10: 
          localus.CTa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 11: 
          localus.FUk.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(72434);
          return 0;
        case 12: 
          localus.FUl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 13: 
          localus.ozC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72434);
          return 0;
        case 14: 
          localus.FUm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72434);
          return 0;
        case 15: 
          localus.FUn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72434);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cra();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localus.FTQ = ((cra)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72434);
        return 0;
      }
      AppMethodBeat.o(72434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.us
 * JD-Core Version:    0.7.0.1
 */