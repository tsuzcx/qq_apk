package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class brh
  extends cvp
{
  public String Fts;
  public cxm GLF;
  public aci GLG;
  public boolean GLH;
  public dtu GLI;
  public bql GLs;
  public String GLv;
  public String GLw;
  public String GLx;
  public do GLy;
  public com.tencent.mm.bx.b nCV;
  public String uiR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123619);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123619);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GLs != null)
      {
        paramVarArgs.lC(2, this.GLs.computeSize());
        this.GLs.writeFields(paramVarArgs);
      }
      if (this.nCV != null) {
        paramVarArgs.c(3, this.nCV);
      }
      if (this.GLF != null)
      {
        paramVarArgs.lC(4, this.GLF.computeSize());
        this.GLF.writeFields(paramVarArgs);
      }
      if (this.uiR != null) {
        paramVarArgs.d(5, this.uiR);
      }
      if (this.Fts != null) {
        paramVarArgs.d(6, this.Fts);
      }
      if (this.GLG != null)
      {
        paramVarArgs.lC(7, this.GLG.computeSize());
        this.GLG.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(8, this.GLH);
      if (this.GLv != null) {
        paramVarArgs.d(9, this.GLv);
      }
      if (this.GLw != null) {
        paramVarArgs.d(10, this.GLw);
      }
      if (this.GLx != null) {
        paramVarArgs.d(11, this.GLx);
      }
      if (this.GLI != null)
      {
        paramVarArgs.lC(12, this.GLI.computeSize());
        this.GLI.writeFields(paramVarArgs);
      }
      if (this.GLy != null)
      {
        paramVarArgs.lC(13, this.GLy.computeSize());
        this.GLy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1546;
      }
    }
    label1546:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GLs != null) {
        paramInt = i + f.a.a.a.lB(2, this.GLs.computeSize());
      }
      i = paramInt;
      if (this.nCV != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.nCV);
      }
      paramInt = i;
      if (this.GLF != null) {
        paramInt = i + f.a.a.a.lB(4, this.GLF.computeSize());
      }
      i = paramInt;
      if (this.uiR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uiR);
      }
      paramInt = i;
      if (this.Fts != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fts);
      }
      i = paramInt;
      if (this.GLG != null) {
        i = paramInt + f.a.a.a.lB(7, this.GLG.computeSize());
      }
      i += f.a.a.b.b.a.alV(8);
      paramInt = i;
      if (this.GLv != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GLv);
      }
      i = paramInt;
      if (this.GLw != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GLw);
      }
      paramInt = i;
      if (this.GLx != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GLx);
      }
      i = paramInt;
      if (this.GLI != null) {
        i = paramInt + f.a.a.a.lB(12, this.GLI.computeSize());
      }
      paramInt = i;
      if (this.GLy != null) {
        paramInt = i + f.a.a.a.lB(13, this.GLy.computeSize());
      }
      AppMethodBeat.o(123619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123619);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brh localbrh = (brh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123619);
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
            localbrh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bql();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrh.GLs = ((bql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 3: 
          localbrh.nCV = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(123619);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrh.GLF = ((cxm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 5: 
          localbrh.uiR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 6: 
          localbrh.Fts = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aci();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aci)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrh.GLG = ((aci)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        case 8: 
          localbrh.GLH = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(123619);
          return 0;
        case 9: 
          localbrh.GLv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 10: 
          localbrh.GLw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 11: 
          localbrh.GLx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123619);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrh.GLI = ((dtu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123619);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new do();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrh.GLy = ((do)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123619);
        return 0;
      }
      AppMethodBeat.o(123619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brh
 * JD-Core Version:    0.7.0.1
 */