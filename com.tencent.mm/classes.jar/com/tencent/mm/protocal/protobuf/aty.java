package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aty
  extends ckq
{
  public String CGX;
  public String CWC;
  public byx DsX;
  public int DtV;
  public String DtW;
  public b DtX;
  public String action_data;
  public String odc;
  public String person_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104371);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.person_id != null) {
        paramVarArgs.d(2, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.d(3, this.action_data);
      }
      paramVarArgs.aR(4, this.DtV);
      if (this.DtW != null) {
        paramVarArgs.d(5, this.DtW);
      }
      if (this.CGX != null) {
        paramVarArgs.d(6, this.CGX);
      }
      paramVarArgs.aR(7, this.scene);
      if (this.CWC != null) {
        paramVarArgs.d(8, this.CWC);
      }
      if (this.odc != null) {
        paramVarArgs.d(9, this.odc);
      }
      if (this.DsX != null)
      {
        paramVarArgs.kX(10, this.DsX.computeSize());
        this.DsX.writeFields(paramVarArgs);
      }
      if (this.DtX != null) {
        paramVarArgs.c(11, this.DtX);
      }
      AppMethodBeat.o(104371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label986;
      }
    }
    label986:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.person_id != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.person_id);
      }
      i = paramInt;
      if (this.action_data != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.action_data);
      }
      i += f.a.a.b.b.a.bA(4, this.DtV);
      paramInt = i;
      if (this.DtW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DtW);
      }
      i = paramInt;
      if (this.CGX != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CGX);
      }
      i += f.a.a.b.b.a.bA(7, this.scene);
      paramInt = i;
      if (this.CWC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CWC);
      }
      i = paramInt;
      if (this.odc != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.odc);
      }
      paramInt = i;
      if (this.DsX != null) {
        paramInt = i + f.a.a.a.kW(10, this.DsX.computeSize());
      }
      i = paramInt;
      if (this.DtX != null) {
        i = paramInt + f.a.a.b.b.a.b(11, this.DtX);
      }
      AppMethodBeat.o(104371);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aty localaty = (aty)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104371);
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
            localaty.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 2: 
          localaty.person_id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 3: 
          localaty.action_data = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 4: 
          localaty.DtV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104371);
          return 0;
        case 5: 
          localaty.DtW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 6: 
          localaty.CGX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 7: 
          localaty.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104371);
          return 0;
        case 8: 
          localaty.CWC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 9: 
          localaty.odc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaty.DsX = ((byx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        }
        localaty.DtX = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(104371);
        return 0;
      }
      AppMethodBeat.o(104371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aty
 * JD-Core Version:    0.7.0.1
 */