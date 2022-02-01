package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class brf
  extends cvp
{
  public String FqI;
  public String FqV;
  public String Fts;
  public String GLA;
  public String GLB;
  public String GLC;
  public int GLD;
  public bql GLs;
  public LinkedList<cxm> Gui;
  public String jdf;
  public String uiR;
  
  public brf()
  {
    AppMethodBeat.i(123616);
    this.Gui = new LinkedList();
    AppMethodBeat.o(123616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123617);
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
      if (this.GLB != null) {
        paramVarArgs.d(3, this.GLB);
      }
      paramVarArgs.e(4, 8, this.Gui);
      if (this.uiR != null) {
        paramVarArgs.d(5, this.uiR);
      }
      if (this.Fts != null) {
        paramVarArgs.d(6, this.Fts);
      }
      if (this.FqV != null) {
        paramVarArgs.d(7, this.FqV);
      }
      if (this.FqI != null) {
        paramVarArgs.d(8, this.FqI);
      }
      if (this.GLC != null) {
        paramVarArgs.d(9, this.GLC);
      }
      paramVarArgs.aS(10, this.GLD);
      if (this.GLA != null) {
        paramVarArgs.d(11, this.GLA);
      }
      if (this.jdf != null) {
        paramVarArgs.d(12, this.jdf);
      }
      AppMethodBeat.o(123617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GLs != null) {
        paramInt = i + f.a.a.a.lB(2, this.GLs.computeSize());
      }
      i = paramInt;
      if (this.GLB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GLB);
      }
      i += f.a.a.a.c(4, 8, this.Gui);
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uiR);
      }
      i = paramInt;
      if (this.Fts != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fts);
      }
      paramInt = i;
      if (this.FqV != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FqV);
      }
      i = paramInt;
      if (this.FqI != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FqI);
      }
      paramInt = i;
      if (this.GLC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GLC);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.GLD);
      paramInt = i;
      if (this.GLA != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GLA);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.jdf);
      }
      AppMethodBeat.o(123617);
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
          AppMethodBeat.o(123617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brf localbrf = (brf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123617);
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
            localbrf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
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
            localbrf.GLs = ((bql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 3: 
          localbrf.GLB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123617);
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
            localbrf.Gui.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 5: 
          localbrf.uiR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 6: 
          localbrf.Fts = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 7: 
          localbrf.FqV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 8: 
          localbrf.FqI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 9: 
          localbrf.GLC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 10: 
          localbrf.GLD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123617);
          return 0;
        case 11: 
          localbrf.GLA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123617);
          return 0;
        }
        localbrf.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123617);
        return 0;
      }
      AppMethodBeat.o(123617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brf
 * JD-Core Version:    0.7.0.1
 */