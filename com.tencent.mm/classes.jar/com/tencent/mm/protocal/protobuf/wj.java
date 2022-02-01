package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wj
  extends com.tencent.mm.bx.a
{
  public String MDt;
  public fmp YCT;
  public etg YCV;
  public String YMe;
  public dbk Zdl;
  public LinkedList<fmp> Zdm;
  public int Zdn;
  public int Zdo;
  public String hAk;
  public int state;
  
  public wj()
  {
    AppMethodBeat.i(91394);
    this.Zdm = new LinkedList();
    AppMethodBeat.o(91394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91395);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zdl != null)
      {
        paramVarArgs.qD(1, this.Zdl.computeSize());
        this.Zdl.writeFields(paramVarArgs);
      }
      if (this.YCT != null)
      {
        paramVarArgs.qD(2, this.YCT.computeSize());
        this.YCT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Zdm);
      if (this.MDt != null) {
        paramVarArgs.g(4, this.MDt);
      }
      if (this.hAk != null) {
        paramVarArgs.g(5, this.hAk);
      }
      if (this.YCV != null)
      {
        paramVarArgs.qD(6, this.YCV.computeSize());
        this.YCV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.state);
      paramVarArgs.bS(8, this.Zdn);
      paramVarArgs.bS(9, this.Zdo);
      if (this.YMe != null) {
        paramVarArgs.g(10, this.YMe);
      }
      AppMethodBeat.o(91395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zdl == null) {
        break label986;
      }
    }
    label986:
    for (paramInt = i.a.a.a.qC(1, this.Zdl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YCT != null) {
        i = paramInt + i.a.a.a.qC(2, this.YCT.computeSize());
      }
      i += i.a.a.a.c(3, 8, this.Zdm);
      paramInt = i;
      if (this.MDt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MDt);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hAk);
      }
      paramInt = i;
      if (this.YCV != null) {
        paramInt = i + i.a.a.a.qC(6, this.YCV.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.state) + i.a.a.b.b.a.cJ(8, this.Zdn) + i.a.a.b.b.a.cJ(9, this.Zdo);
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YMe);
      }
      AppMethodBeat.o(91395);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zdm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        wj localwj = (wj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91395);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbk)localObject2).parseFrom((byte[])localObject1);
            }
            localwj.Zdl = ((dbk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localwj.YCT = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localwj.Zdm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 4: 
          localwj.MDt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 5: 
          localwj.hAk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etg)localObject2).parseFrom((byte[])localObject1);
            }
            localwj.YCV = ((etg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 7: 
          localwj.state = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91395);
          return 0;
        case 8: 
          localwj.Zdn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91395);
          return 0;
        case 9: 
          localwj.Zdo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91395);
          return 0;
        }
        localwj.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91395);
        return 0;
      }
      AppMethodBeat.o(91395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wj
 * JD-Core Version:    0.7.0.1
 */