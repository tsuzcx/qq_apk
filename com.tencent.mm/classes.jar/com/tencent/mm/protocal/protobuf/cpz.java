package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpz
  extends dyl
{
  public ack RPD;
  public String SlT;
  public int TkK;
  public boolean TnO;
  public boolean TnP;
  public fnd Txh;
  public fpb Txi;
  public foc Txj;
  public fqa Txk;
  public fot Txl;
  public fpc Txm;
  public int Txn;
  public String Txo;
  public String Txp;
  public fpd Txq;
  public dcc Txr;
  public foy Txs;
  public int Txt;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123624);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.Txh != null)
      {
        paramVarArgs.oE(3, this.Txh.computeSize());
        this.Txh.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.TkK);
      if (this.Txi != null)
      {
        paramVarArgs.oE(5, this.Txi.computeSize());
        this.Txi.writeFields(paramVarArgs);
      }
      if (this.Txj != null)
      {
        paramVarArgs.oE(6, this.Txj.computeSize());
        this.Txj.writeFields(paramVarArgs);
      }
      if (this.Txk != null)
      {
        paramVarArgs.oE(7, this.Txk.computeSize());
        this.Txk.writeFields(paramVarArgs);
      }
      if (this.Txl != null)
      {
        paramVarArgs.oE(8, this.Txl.computeSize());
        this.Txl.writeFields(paramVarArgs);
      }
      if (this.Txm != null)
      {
        paramVarArgs.oE(9, this.Txm.computeSize());
        this.Txm.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.Txn);
      if (this.Txo != null) {
        paramVarArgs.f(11, this.Txo);
      }
      if (this.Txp != null) {
        paramVarArgs.f(12, this.Txp);
      }
      paramVarArgs.co(13, this.TnO);
      paramVarArgs.co(14, this.TnP);
      if (this.Txq != null)
      {
        paramVarArgs.oE(15, this.Txq.computeSize());
        this.Txq.writeFields(paramVarArgs);
      }
      if (this.Txr != null)
      {
        paramVarArgs.oE(16, this.Txr.computeSize());
        this.Txr.writeFields(paramVarArgs);
      }
      if (this.SlT != null) {
        paramVarArgs.f(17, this.SlT);
      }
      if (this.RPD != null)
      {
        paramVarArgs.oE(18, this.RPD.computeSize());
        this.RPD.writeFields(paramVarArgs);
      }
      if (this.Txs != null)
      {
        paramVarArgs.oE(19, this.Txs.computeSize());
        this.Txs.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(20, this.Txt);
      AppMethodBeat.o(123624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2092;
      }
    }
    label2092:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.Txh != null) {
        i = paramInt + g.a.a.a.oD(3, this.Txh.computeSize());
      }
      i += g.a.a.b.b.a.bM(4, this.TkK);
      paramInt = i;
      if (this.Txi != null) {
        paramInt = i + g.a.a.a.oD(5, this.Txi.computeSize());
      }
      i = paramInt;
      if (this.Txj != null) {
        i = paramInt + g.a.a.a.oD(6, this.Txj.computeSize());
      }
      paramInt = i;
      if (this.Txk != null) {
        paramInt = i + g.a.a.a.oD(7, this.Txk.computeSize());
      }
      i = paramInt;
      if (this.Txl != null) {
        i = paramInt + g.a.a.a.oD(8, this.Txl.computeSize());
      }
      paramInt = i;
      if (this.Txm != null) {
        paramInt = i + g.a.a.a.oD(9, this.Txm.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.Txn);
      paramInt = i;
      if (this.Txo != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Txo);
      }
      i = paramInt;
      if (this.Txp != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.Txp);
      }
      i = i + (g.a.a.b.b.a.gL(13) + 1) + (g.a.a.b.b.a.gL(14) + 1);
      paramInt = i;
      if (this.Txq != null) {
        paramInt = i + g.a.a.a.oD(15, this.Txq.computeSize());
      }
      i = paramInt;
      if (this.Txr != null) {
        i = paramInt + g.a.a.a.oD(16, this.Txr.computeSize());
      }
      paramInt = i;
      if (this.SlT != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.SlT);
      }
      i = paramInt;
      if (this.RPD != null) {
        i = paramInt + g.a.a.a.oD(18, this.RPD.computeSize());
      }
      paramInt = i;
      if (this.Txs != null) {
        paramInt = i + g.a.a.a.oD(19, this.Txs.computeSize());
      }
      i = g.a.a.b.b.a.bM(20, this.Txt);
      AppMethodBeat.o(123624);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpz localcpz = (cpz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123624);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 2: 
          localcpz.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnd)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.Txh = ((fnd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 4: 
          localcpz.TkK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123624);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpb)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.Txi = ((fpb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foc)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.Txj = ((foc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqa)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.Txk = ((fqa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fot();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fot)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.Txl = ((fot)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpc)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.Txm = ((fpc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 10: 
          localcpz.Txn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123624);
          return 0;
        case 11: 
          localcpz.Txo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 12: 
          localcpz.Txp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 13: 
          localcpz.TnO = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(123624);
          return 0;
        case 14: 
          localcpz.TnP = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(123624);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpd)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.Txq = ((fpd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcc)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.Txr = ((dcc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 17: 
          localcpz.SlT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ack();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ack)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.RPD = ((ack)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foy)localObject2).parseFrom((byte[])localObject1);
            }
            localcpz.Txs = ((foy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        }
        localcpz.Txt = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(123624);
        return 0;
      }
      AppMethodBeat.o(123624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpz
 * JD-Core Version:    0.7.0.1
 */