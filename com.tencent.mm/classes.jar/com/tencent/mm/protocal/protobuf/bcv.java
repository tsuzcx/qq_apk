package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcv
  extends cwj
{
  public String Dcj;
  public boolean Dck;
  public String Dcl;
  public String Dcm;
  public String Dcn;
  public String Dco;
  public String Dcp;
  public String Dcq;
  public boolean Dcs;
  public LinkedList<boo> GSr;
  public int dmy;
  public String phe;
  
  public bcv()
  {
    AppMethodBeat.i(72486);
    this.dmy = 0;
    this.phe = "ok";
    this.GSr = new LinkedList();
    AppMethodBeat.o(72486);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72487);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      if (this.Dcj != null) {
        paramVarArgs.d(4, this.Dcj);
      }
      paramVarArgs.bC(6, this.Dck);
      if (this.Dcl != null) {
        paramVarArgs.d(7, this.Dcl);
      }
      if (this.Dcm != null) {
        paramVarArgs.d(8, this.Dcm);
      }
      if (this.Dcn != null) {
        paramVarArgs.d(9, this.Dcn);
      }
      if (this.Dco != null) {
        paramVarArgs.d(10, this.Dco);
      }
      if (this.Dcp != null) {
        paramVarArgs.d(11, this.Dcp);
      }
      if (this.Dcq != null) {
        paramVarArgs.d(12, this.Dcq);
      }
      paramVarArgs.e(13, 8, this.GSr);
      paramVarArgs.bC(14, this.Dcs);
      AppMethodBeat.o(72487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.Dcj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Dcj);
      }
      i += f.a.a.b.b.a.amF(6);
      paramInt = i;
      if (this.Dcl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dcl);
      }
      i = paramInt;
      if (this.Dcm != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Dcm);
      }
      paramInt = i;
      if (this.Dcn != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Dcn);
      }
      i = paramInt;
      if (this.Dco != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Dco);
      }
      paramInt = i;
      if (this.Dcp != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Dcp);
      }
      i = paramInt;
      if (this.Dcq != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Dcq);
      }
      paramInt = f.a.a.a.c(13, 8, this.GSr);
      int j = f.a.a.b.b.a.amF(14);
      AppMethodBeat.o(72487);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GSr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcv localbcv = (bcv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(72487);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        case 2: 
          localbcv.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72487);
          return 0;
        case 3: 
          localbcv.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 4: 
          localbcv.Dcj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 6: 
          localbcv.Dck = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(72487);
          return 0;
        case 7: 
          localbcv.Dcl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 8: 
          localbcv.Dcm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 9: 
          localbcv.Dcn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 10: 
          localbcv.Dco = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 11: 
          localbcv.Dcp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 12: 
          localbcv.Dcq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcv.GSr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        }
        localbcv.Dcs = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(72487);
        return 0;
      }
      AppMethodBeat.o(72487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcv
 * JD-Core Version:    0.7.0.1
 */