package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class csa
  extends dop
{
  public apc LAv;
  public aov LBM;
  public b LBu;
  public avk LDR;
  public b LDs;
  public atn LEs;
  public b LEu;
  public efo LEv;
  public LinkedList<ecq> LEw;
  public buj LEx;
  public int Mxd;
  public String Mxe;
  public bcc Mxf;
  public aoz Mxg;
  public String Mxh;
  public float dTj;
  public float latitude;
  public long object_id;
  public String object_nonce_id;
  public String pPy;
  public String pPz;
  public int scene;
  public String source;
  public blo tVd;
  
  public csa()
  {
    AppMethodBeat.i(256712);
    this.LEw = new LinkedList();
    AppMethodBeat.o(256712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LBM != null)
      {
        paramVarArgs.ni(2, this.LBM.computeSize());
        this.LBM.writeFields(paramVarArgs);
      }
      if (this.LDs != null) {
        paramVarArgs.c(3, this.LDs);
      }
      paramVarArgs.bb(4, this.object_id);
      paramVarArgs.E(6, this.dTj);
      paramVarArgs.E(7, this.latitude);
      paramVarArgs.aM(5, this.Mxd);
      if (this.object_nonce_id != null) {
        paramVarArgs.e(8, this.object_nonce_id);
      }
      if (this.Mxe != null) {
        paramVarArgs.e(9, this.Mxe);
      }
      paramVarArgs.aM(10, this.scene);
      if (this.source != null) {
        paramVarArgs.e(11, this.source);
      }
      if (this.Mxf != null)
      {
        paramVarArgs.ni(12, this.Mxf.computeSize());
        this.Mxf.writeFields(paramVarArgs);
      }
      if (this.Mxg != null)
      {
        paramVarArgs.ni(13, this.Mxg.computeSize());
        this.Mxg.writeFields(paramVarArgs);
      }
      if (this.LBu != null) {
        paramVarArgs.c(14, this.LBu);
      }
      if (this.LAv != null)
      {
        paramVarArgs.ni(15, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      if (this.pPy != null) {
        paramVarArgs.e(16, this.pPy);
      }
      if (this.pPz != null) {
        paramVarArgs.e(17, this.pPz);
      }
      if (this.LEs != null)
      {
        paramVarArgs.ni(18, this.LEs.computeSize());
        this.LEs.writeFields(paramVarArgs);
      }
      if (this.Mxh != null) {
        paramVarArgs.e(19, this.Mxh);
      }
      if (this.LEu != null) {
        paramVarArgs.c(20, this.LEu);
      }
      if (this.LEv != null)
      {
        paramVarArgs.ni(21, this.LEv.computeSize());
        this.LEv.writeFields(paramVarArgs);
      }
      if (this.tVd != null)
      {
        paramVarArgs.ni(22, this.tVd.computeSize());
        this.tVd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.LEw);
      if (this.LEx != null)
      {
        paramVarArgs.ni(24, this.LEx.computeSize());
        this.LEx.writeFields(paramVarArgs);
      }
      if (this.LDR != null)
      {
        paramVarArgs.ni(25, this.LDR.computeSize());
        this.LDR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2632;
      }
    }
    label2632:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LBM != null) {
        paramInt = i + g.a.a.a.nh(2, this.LBM.computeSize());
      }
      i = paramInt;
      if (this.LDs != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LDs);
      }
      i = i + g.a.a.b.b.a.r(4, this.object_id) + (g.a.a.b.b.a.fS(6) + 4) + (g.a.a.b.b.a.fS(7) + 4) + g.a.a.b.b.a.bu(5, this.Mxd);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.object_nonce_id);
      }
      i = paramInt;
      if (this.Mxe != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Mxe);
      }
      i += g.a.a.b.b.a.bu(10, this.scene);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.source);
      }
      i = paramInt;
      if (this.Mxf != null) {
        i = paramInt + g.a.a.a.nh(12, this.Mxf.computeSize());
      }
      paramInt = i;
      if (this.Mxg != null) {
        paramInt = i + g.a.a.a.nh(13, this.Mxg.computeSize());
      }
      i = paramInt;
      if (this.LBu != null) {
        i = paramInt + g.a.a.b.b.a.b(14, this.LBu);
      }
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(15, this.LAv.computeSize());
      }
      i = paramInt;
      if (this.pPy != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.pPy);
      }
      paramInt = i;
      if (this.pPz != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.pPz);
      }
      i = paramInt;
      if (this.LEs != null) {
        i = paramInt + g.a.a.a.nh(18, this.LEs.computeSize());
      }
      paramInt = i;
      if (this.Mxh != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.Mxh);
      }
      i = paramInt;
      if (this.LEu != null) {
        i = paramInt + g.a.a.b.b.a.b(20, this.LEu);
      }
      paramInt = i;
      if (this.LEv != null) {
        paramInt = i + g.a.a.a.nh(21, this.LEv.computeSize());
      }
      i = paramInt;
      if (this.tVd != null) {
        i = paramInt + g.a.a.a.nh(22, this.tVd.computeSize());
      }
      i += g.a.a.a.c(23, 8, this.LEw);
      paramInt = i;
      if (this.LEx != null) {
        paramInt = i + g.a.a.a.nh(24, this.LEx.computeSize());
      }
      i = paramInt;
      if (this.LDR != null) {
        i = paramInt + g.a.a.a.nh(25, this.LDR.computeSize());
      }
      AppMethodBeat.o(256713);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LEw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256713);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csa localcsa = (csa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256713);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.LBM = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        case 3: 
          localcsa.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(256713);
          return 0;
        case 4: 
          localcsa.object_id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(256713);
          return 0;
        case 6: 
          localcsa.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(256713);
          return 0;
        case 7: 
          localcsa.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(256713);
          return 0;
        case 5: 
          localcsa.Mxd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256713);
          return 0;
        case 8: 
          localcsa.object_nonce_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256713);
          return 0;
        case 9: 
          localcsa.Mxe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256713);
          return 0;
        case 10: 
          localcsa.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256713);
          return 0;
        case 11: 
          localcsa.source = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256713);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.Mxf = ((bcc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.Mxg = ((aoz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        case 14: 
          localcsa.LBu = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(256713);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.LAv = ((apc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        case 16: 
          localcsa.pPy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256713);
          return 0;
        case 17: 
          localcsa.pPz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256713);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.LEs = ((atn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        case 19: 
          localcsa.Mxh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256713);
          return 0;
        case 20: 
          localcsa.LEu = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(256713);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.LEv = ((efo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.tVd = ((blo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.LEw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsa.LEx = ((buj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256713);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcsa.LDR = ((avk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256713);
        return 0;
      }
      AppMethodBeat.o(256713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csa
 * JD-Core Version:    0.7.0.1
 */