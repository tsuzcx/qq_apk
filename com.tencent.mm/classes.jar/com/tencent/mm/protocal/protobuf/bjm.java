package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjm
  extends com.tencent.mm.bx.a
{
  public String YBM;
  public bfs ZOA;
  public int ZOf;
  public bgh ZTa;
  public bgh ZTb;
  public bmg ZTc;
  public LinkedList<bjl> ZTd;
  public bjn ZTe;
  public int status;
  
  public bjm()
  {
    AppMethodBeat.i(260008);
    this.ZTd = new LinkedList();
    AppMethodBeat.o(260008);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260014);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YBM != null) {
        paramVarArgs.g(1, this.YBM);
      }
      paramVarArgs.bS(2, this.ZOf);
      if (this.ZTa != null)
      {
        paramVarArgs.qD(3, this.ZTa.computeSize());
        this.ZTa.writeFields(paramVarArgs);
      }
      if (this.ZTb != null)
      {
        paramVarArgs.qD(4, this.ZTb.computeSize());
        this.ZTb.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.status);
      if (this.ZTc != null)
      {
        paramVarArgs.qD(6, this.ZTc.computeSize());
        this.ZTc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.ZTd);
      if (this.ZTe != null)
      {
        paramVarArgs.qD(8, this.ZTe.computeSize());
        this.ZTe.writeFields(paramVarArgs);
      }
      if (this.ZOA != null)
      {
        paramVarArgs.qD(9, this.ZOA.computeSize());
        this.ZOA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260014);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YBM == null) {
        break label1090;
      }
    }
    label1090:
    for (paramInt = i.a.a.b.b.a.h(1, this.YBM) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZOf);
      paramInt = i;
      if (this.ZTa != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZTa.computeSize());
      }
      i = paramInt;
      if (this.ZTb != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZTb.computeSize());
      }
      i += i.a.a.b.b.a.cJ(5, this.status);
      paramInt = i;
      if (this.ZTc != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZTc.computeSize());
      }
      i = paramInt + i.a.a.a.c(7, 8, this.ZTd);
      paramInt = i;
      if (this.ZTe != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZTe.computeSize());
      }
      i = paramInt;
      if (this.ZOA != null) {
        i = paramInt + i.a.a.a.qC(9, this.ZOA.computeSize());
      }
      AppMethodBeat.o(260014);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZTd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260014);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bjm localbjm = (bjm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260014);
          return -1;
        case 1: 
          localbjm.YBM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260014);
          return 0;
        case 2: 
          localbjm.ZOf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260014);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgh)localObject2).parseFrom((byte[])localObject1);
            }
            localbjm.ZTa = ((bgh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260014);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgh)localObject2).parseFrom((byte[])localObject1);
            }
            localbjm.ZTb = ((bgh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260014);
          return 0;
        case 5: 
          localbjm.status = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260014);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmg)localObject2).parseFrom((byte[])localObject1);
            }
            localbjm.ZTc = ((bmg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260014);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjl)localObject2).parseFrom((byte[])localObject1);
            }
            localbjm.ZTd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260014);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjn)localObject2).parseFrom((byte[])localObject1);
            }
            localbjm.ZTe = ((bjn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260014);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfs)localObject2).parseFrom((byte[])localObject1);
          }
          localbjm.ZOA = ((bfs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260014);
        return 0;
      }
      AppMethodBeat.o(260014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjm
 * JD-Core Version:    0.7.0.1
 */