package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bbu
  extends cvw
{
  public String FXr;
  public cjm GQF;
  public int GRK;
  public String GRL;
  public b GRM;
  public boolean GRN;
  public String GoW;
  public String action_data;
  public String person_id;
  public String pqK;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104371);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.person_id != null) {
        paramVarArgs.d(2, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.d(3, this.action_data);
      }
      paramVarArgs.aS(4, this.GRK);
      if (this.GRL != null) {
        paramVarArgs.d(5, this.GRL);
      }
      if (this.FXr != null) {
        paramVarArgs.d(6, this.FXr);
      }
      paramVarArgs.aS(7, this.scene);
      if (this.GoW != null) {
        paramVarArgs.d(8, this.GoW);
      }
      if (this.pqK != null) {
        paramVarArgs.d(9, this.pqK);
      }
      if (this.GQF != null)
      {
        paramVarArgs.lJ(10, this.GQF.computeSize());
        this.GQF.writeFields(paramVarArgs);
      }
      if (this.GRM != null) {
        paramVarArgs.c(11, this.GRM);
      }
      paramVarArgs.bC(12, this.GRN);
      AppMethodBeat.o(104371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.person_id != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.person_id);
      }
      i = paramInt;
      if (this.action_data != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.action_data);
      }
      i += f.a.a.b.b.a.bz(4, this.GRK);
      paramInt = i;
      if (this.GRL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GRL);
      }
      i = paramInt;
      if (this.FXr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FXr);
      }
      i += f.a.a.b.b.a.bz(7, this.scene);
      paramInt = i;
      if (this.GoW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GoW);
      }
      i = paramInt;
      if (this.pqK != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.pqK);
      }
      paramInt = i;
      if (this.GQF != null) {
        paramInt = i + f.a.a.a.lI(10, this.GQF.computeSize());
      }
      i = paramInt;
      if (this.GRM != null) {
        i = paramInt + f.a.a.b.b.a.b(11, this.GRM);
      }
      paramInt = f.a.a.b.b.a.amF(12);
      AppMethodBeat.o(104371);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbu localbbu = (bbu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104371);
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
            localbbu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 2: 
          localbbu.person_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 3: 
          localbbu.action_data = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 4: 
          localbbu.GRK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104371);
          return 0;
        case 5: 
          localbbu.GRL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 6: 
          localbbu.FXr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 7: 
          localbbu.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104371);
          return 0;
        case 8: 
          localbbu.GoW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 9: 
          localbbu.pqK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbu.GQF = ((cjm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 11: 
          localbbu.GRM = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(104371);
          return 0;
        }
        localbbu.GRN = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(104371);
        return 0;
      }
      AppMethodBeat.o(104371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbu
 * JD-Core Version:    0.7.0.1
 */