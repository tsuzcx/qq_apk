package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pz
  extends com.tencent.mm.bx.a
{
  public String DVu;
  public int YEI;
  public int YHv;
  public String YIf;
  public String YUk;
  public int YUl;
  public int YUm;
  public int YUn;
  public int YUo;
  public int YUp;
  public long YUq;
  public LinkedList<String> YUr;
  public akj YUs;
  public int YUt;
  public String YUu;
  public int YUv;
  public int eQp;
  public LinkedList<String> hrh;
  public int msg_type;
  public int tNW;
  public int time;
  public String url;
  public int weight;
  
  public pz()
  {
    AppMethodBeat.i(257776);
    this.hrh = new LinkedList();
    this.YUr = new LinkedList();
    AppMethodBeat.o(257776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124437);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YUk != null) {
        paramVarArgs.g(1, this.YUk);
      }
      paramVarArgs.bS(2, this.weight);
      paramVarArgs.bS(3, this.YUl);
      paramVarArgs.bS(4, this.eQp);
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      paramVarArgs.bS(6, this.time);
      paramVarArgs.bS(7, this.YUm);
      paramVarArgs.bS(8, this.YUn);
      paramVarArgs.bS(9, this.YUo);
      paramVarArgs.bS(10, this.YUp);
      paramVarArgs.bS(11, this.YEI);
      paramVarArgs.bS(12, this.YHv);
      paramVarArgs.bS(13, this.tNW);
      paramVarArgs.e(14, 1, this.hrh);
      paramVarArgs.bv(15, this.YUq);
      if (this.DVu != null) {
        paramVarArgs.g(18, this.DVu);
      }
      paramVarArgs.e(19, 1, this.YUr);
      if (this.YUs != null)
      {
        paramVarArgs.qD(20, this.YUs.computeSize());
        this.YUs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(21, this.YUt);
      if (this.YUu != null) {
        paramVarArgs.g(22, this.YUu);
      }
      paramVarArgs.bS(24, this.msg_type);
      if (this.YIf != null) {
        paramVarArgs.g(25, this.YIf);
      }
      paramVarArgs.bS(26, this.YUv);
      AppMethodBeat.o(124437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YUk == null) {
        break label1388;
      }
    }
    label1388:
    for (paramInt = i.a.a.b.b.a.h(1, this.YUk) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.weight) + i.a.a.b.b.a.cJ(3, this.YUl) + i.a.a.b.b.a.cJ(4, this.eQp);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.time) + i.a.a.b.b.a.cJ(7, this.YUm) + i.a.a.b.b.a.cJ(8, this.YUn) + i.a.a.b.b.a.cJ(9, this.YUo) + i.a.a.b.b.a.cJ(10, this.YUp) + i.a.a.b.b.a.cJ(11, this.YEI) + i.a.a.b.b.a.cJ(12, this.YHv) + i.a.a.b.b.a.cJ(13, this.tNW) + i.a.a.a.c(14, 1, this.hrh) + i.a.a.b.b.a.q(15, this.YUq);
      paramInt = i;
      if (this.DVu != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.DVu);
      }
      i = paramInt + i.a.a.a.c(19, 1, this.YUr);
      paramInt = i;
      if (this.YUs != null) {
        paramInt = i + i.a.a.a.qC(20, this.YUs.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(21, this.YUt);
      paramInt = i;
      if (this.YUu != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.YUu);
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.msg_type);
      paramInt = i;
      if (this.YIf != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.YIf);
      }
      i = i.a.a.b.b.a.cJ(26, this.YUv);
      AppMethodBeat.o(124437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hrh.clear();
        this.YUr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        pz localpz = (pz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 16: 
        case 17: 
        case 23: 
        default: 
          AppMethodBeat.o(124437);
          return -1;
        case 1: 
          localpz.YUk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 2: 
          localpz.weight = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 3: 
          localpz.YUl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 4: 
          localpz.eQp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 5: 
          localpz.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 6: 
          localpz.time = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 7: 
          localpz.YUm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 8: 
          localpz.YUn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 9: 
          localpz.YUo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 10: 
          localpz.YUp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 11: 
          localpz.YEI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 12: 
          localpz.YHv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 13: 
          localpz.tNW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 14: 
          localpz.hrh.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(124437);
          return 0;
        case 15: 
          localpz.YUq = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(124437);
          return 0;
        case 18: 
          localpz.DVu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 19: 
          localpz.YUr.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(124437);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            akj localakj = new akj();
            if ((localObject != null) && (localObject.length > 0)) {
              localakj.parseFrom((byte[])localObject);
            }
            localpz.YUs = localakj;
            paramInt += 1;
          }
          AppMethodBeat.o(124437);
          return 0;
        case 21: 
          localpz.YUt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 22: 
          localpz.YUu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 24: 
          localpz.msg_type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124437);
          return 0;
        case 25: 
          localpz.YIf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124437);
          return 0;
        }
        localpz.YUv = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124437);
        return 0;
      }
      AppMethodBeat.o(124437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pz
 * JD-Core Version:    0.7.0.1
 */