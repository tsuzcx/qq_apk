package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnf
  extends esc
{
  public long aaqE;
  public boolean aaqF;
  public long aaqG;
  public LinkedList<vx> aaqH;
  public LinkedList<vt> nUC;
  public String title;
  public String wuA;
  
  public cnf()
  {
    AppMethodBeat.i(260068);
    this.aaqH = new LinkedList();
    this.nUC = new LinkedList();
    AppMethodBeat.o(260068);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260078);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260078);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aaqE);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.di(4, this.aaqF);
      paramVarArgs.bv(5, this.aaqG);
      if (this.title != null) {
        paramVarArgs.g(6, this.title);
      }
      paramVarArgs.e(7, 8, this.aaqH);
      paramVarArgs.e(8, 8, this.nUC);
      AppMethodBeat.o(260078);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label824;
      }
    }
    label824:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aaqE);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 1) + i.a.a.b.b.a.q(5, this.aaqG);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.title);
      }
      i = i.a.a.a.c(7, 8, this.aaqH);
      int j = i.a.a.a.c(8, 8, this.nUC);
      AppMethodBeat.o(260078);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaqH.clear();
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(260078);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260078);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cnf localcnf = (cnf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260078);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcnf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260078);
          return 0;
        case 2: 
          localcnf.aaqE = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260078);
          return 0;
        case 3: 
          localcnf.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260078);
          return 0;
        case 4: 
          localcnf.aaqF = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(260078);
          return 0;
        case 5: 
          localcnf.aaqG = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260078);
          return 0;
        case 6: 
          localcnf.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260078);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vx)localObject2).parseFrom((byte[])localObject1);
            }
            localcnf.aaqH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260078);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new vt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((vt)localObject2).parseFrom((byte[])localObject1);
          }
          localcnf.nUC.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260078);
        return 0;
      }
      AppMethodBeat.o(260078);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnf
 * JD-Core Version:    0.7.0.1
 */