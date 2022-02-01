package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class brb
  extends cvp
{
  public String Fts;
  public bql GLs;
  public String GLv;
  public String GLw;
  public String GLx;
  public do GLy;
  public LinkedList<cxm> Gui;
  public String uiR;
  
  public brb()
  {
    AppMethodBeat.i(123609);
    this.Gui = new LinkedList();
    AppMethodBeat.o(123609);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123610);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123610);
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
      paramVarArgs.e(3, 8, this.Gui);
      if (this.uiR != null) {
        paramVarArgs.d(4, this.uiR);
      }
      if (this.Fts != null) {
        paramVarArgs.d(5, this.Fts);
      }
      if (this.GLv != null) {
        paramVarArgs.d(6, this.GLv);
      }
      if (this.GLw != null) {
        paramVarArgs.d(7, this.GLw);
      }
      if (this.GLx != null) {
        paramVarArgs.d(8, this.GLx);
      }
      if (this.GLy != null)
      {
        paramVarArgs.lC(9, this.GLy.computeSize());
        this.GLy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GLs != null) {
        i = paramInt + f.a.a.a.lB(2, this.GLs.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.Gui);
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uiR);
      }
      i = paramInt;
      if (this.Fts != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fts);
      }
      paramInt = i;
      if (this.GLv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GLv);
      }
      i = paramInt;
      if (this.GLw != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GLw);
      }
      paramInt = i;
      if (this.GLx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GLx);
      }
      i = paramInt;
      if (this.GLy != null) {
        i = paramInt + f.a.a.a.lB(9, this.GLy.computeSize());
      }
      AppMethodBeat.o(123610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gui.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123610);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brb localbrb = (brb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123610);
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
            localbrb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
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
            localbrb.GLs = ((bql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrb.Gui.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123610);
          return 0;
        case 4: 
          localbrb.uiR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 5: 
          localbrb.Fts = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 6: 
          localbrb.GLv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 7: 
          localbrb.GLw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123610);
          return 0;
        case 8: 
          localbrb.GLx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123610);
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
          localbrb.GLy = ((do)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123610);
        return 0;
      }
      AppMethodBeat.o(123610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brb
 * JD-Core Version:    0.7.0.1
 */