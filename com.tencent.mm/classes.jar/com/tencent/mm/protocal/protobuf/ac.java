package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends ckq
{
  public String Cth;
  public String Cti;
  public String Ctj;
  public LinkedList<dt> Ctk;
  public int Ctl;
  public String Ctm;
  public int Ctn;
  public String Cto;
  public int OpCode;
  public String SSID;
  public String URL;
  
  public ac()
  {
    AppMethodBeat.i(32095);
    this.Ctk = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.d(2, this.URL);
      }
      if (this.SSID != null) {
        paramVarArgs.d(3, this.SSID);
      }
      if (this.Cth != null) {
        paramVarArgs.d(4, this.Cth);
      }
      if (this.Cti != null) {
        paramVarArgs.d(5, this.Cti);
      }
      if (this.Ctj != null) {
        paramVarArgs.d(6, this.Ctj);
      }
      paramVarArgs.aR(7, this.OpCode);
      paramVarArgs.e(8, 8, this.Ctk);
      paramVarArgs.aR(9, this.Ctl);
      if (this.Ctm != null) {
        paramVarArgs.d(10, this.Ctm);
      }
      paramVarArgs.aR(11, this.Ctn);
      if (this.Cto != null) {
        paramVarArgs.d(12, this.Cto);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
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
      if (this.Cth != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Cth);
      }
      i = paramInt;
      if (this.Cti != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Cti);
      }
      paramInt = i;
      if (this.Ctj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ctj);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.OpCode) + f.a.a.a.c(8, 8, this.Ctk) + f.a.a.b.b.a.bA(9, this.Ctl);
      paramInt = i;
      if (this.Ctm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ctm);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.Ctn);
      paramInt = i;
      if (this.Cto != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Cto);
      }
      AppMethodBeat.o(32096);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ctk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localac.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 2: 
          localac.URL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 3: 
          localac.SSID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 4: 
          localac.Cth = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 5: 
          localac.Cti = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 6: 
          localac.Ctj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 7: 
          localac.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32096);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localac.Ctk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 9: 
          localac.Ctl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32096);
          return 0;
        case 10: 
          localac.Ctm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 11: 
          localac.Ctn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32096);
          return 0;
        }
        localac.Cto = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32096);
        return 0;
      }
      AppMethodBeat.o(32096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */