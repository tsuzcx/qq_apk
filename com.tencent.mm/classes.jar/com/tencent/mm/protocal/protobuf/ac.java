package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends cvw
{
  public String FJb;
  public String FJc;
  public String FJd;
  public LinkedList<dw> FJe;
  public int FJf;
  public String FJg;
  public int FJh;
  public String FJi;
  public int OpCode;
  public String SSID;
  public String URL;
  
  public ac()
  {
    AppMethodBeat.i(32095);
    this.FJe = new LinkedList();
    AppMethodBeat.o(32095);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32096);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.d(2, this.URL);
      }
      if (this.SSID != null) {
        paramVarArgs.d(3, this.SSID);
      }
      if (this.FJb != null) {
        paramVarArgs.d(4, this.FJb);
      }
      if (this.FJc != null) {
        paramVarArgs.d(5, this.FJc);
      }
      if (this.FJd != null) {
        paramVarArgs.d(6, this.FJd);
      }
      paramVarArgs.aS(7, this.OpCode);
      paramVarArgs.e(8, 8, this.FJe);
      paramVarArgs.aS(9, this.FJf);
      if (this.FJg != null) {
        paramVarArgs.d(10, this.FJg);
      }
      paramVarArgs.aS(11, this.FJh);
      if (this.FJi != null) {
        paramVarArgs.d(12, this.FJi);
      }
      AppMethodBeat.o(32096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1032;
      }
    }
    label1032:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.URL);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.SSID);
      }
      paramInt = i;
      if (this.FJb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FJb);
      }
      i = paramInt;
      if (this.FJc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FJc);
      }
      paramInt = i;
      if (this.FJd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FJd);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.OpCode) + f.a.a.a.c(8, 8, this.FJe) + f.a.a.b.b.a.bz(9, this.FJf);
      paramInt = i;
      if (this.FJg != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FJg);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.FJh);
      paramInt = i;
      if (this.FJi != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FJi);
      }
      AppMethodBeat.o(32096);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32096);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ac localac = (ac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32096);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localac.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 2: 
          localac.URL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 3: 
          localac.SSID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 4: 
          localac.FJb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 5: 
          localac.FJc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 6: 
          localac.FJd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 7: 
          localac.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32096);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localac.FJe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 9: 
          localac.FJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32096);
          return 0;
        case 10: 
          localac.FJg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 11: 
          localac.FJh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32096);
          return 0;
        }
        localac.FJi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32096);
        return 0;
      }
      AppMethodBeat.o(32096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */