package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class bdm
  extends com.tencent.mm.bx.a
{
  public String Tro;
  public bgh ZNW;
  public long ZNX;
  public b ZNY;
  public ben ZNZ;
  public LinkedList<bgh> ZOa;
  public bgh ZOb;
  public String ZOc;
  public int ZOd;
  public bfv akjQ;
  public int msg_type;
  public long seq;
  public String session_id;
  
  public bdm()
  {
    AppMethodBeat.i(259044);
    this.ZOa = new LinkedList();
    AppMethodBeat.o(259044);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259052);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZNW != null)
      {
        paramVarArgs.qD(1, this.ZNW.computeSize());
        this.ZNW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.msg_type);
      if (this.Tro != null) {
        paramVarArgs.g(3, this.Tro);
      }
      paramVarArgs.bv(4, this.ZNX);
      if (this.ZNY != null) {
        paramVarArgs.d(5, this.ZNY);
      }
      if (this.ZNZ != null)
      {
        paramVarArgs.qD(6, this.ZNZ.computeSize());
        this.ZNZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.ZOa);
      if (this.session_id != null) {
        paramVarArgs.g(51, this.session_id);
      }
      if (this.akjQ != null)
      {
        paramVarArgs.qD(52, this.akjQ.computeSize());
        this.akjQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(101, this.seq);
      if (this.ZOb != null)
      {
        paramVarArgs.qD(102, this.ZOb.computeSize());
        this.ZOb.writeFields(paramVarArgs);
      }
      if (this.ZOc != null) {
        paramVarArgs.g(103, this.ZOc);
      }
      paramVarArgs.bS(1000, this.ZOd);
      AppMethodBeat.o(259052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZNW == null) {
        break label1284;
      }
    }
    label1284:
    for (paramInt = i.a.a.a.qC(1, this.ZNW.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.msg_type);
      paramInt = i;
      if (this.Tro != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Tro);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.ZNX);
      paramInt = i;
      if (this.ZNY != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZNY);
      }
      i = paramInt;
      if (this.ZNZ != null) {
        i = paramInt + i.a.a.a.qC(6, this.ZNZ.computeSize());
      }
      i += i.a.a.a.c(7, 8, this.ZOa);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(51, this.session_id);
      }
      i = paramInt;
      if (this.akjQ != null) {
        i = paramInt + i.a.a.a.qC(52, this.akjQ.computeSize());
      }
      i += i.a.a.b.b.a.q(101, this.seq);
      paramInt = i;
      if (this.ZOb != null) {
        paramInt = i + i.a.a.a.qC(102, this.ZOb.computeSize());
      }
      i = paramInt;
      if (this.ZOc != null) {
        i = paramInt + i.a.a.b.b.a.h(103, this.ZOc);
      }
      paramInt = i.a.a.b.b.a.cJ(1000, this.ZOd);
      AppMethodBeat.o(259052);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZOa.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259052);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bdm localbdm = (bdm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259052);
          return -1;
        case 1: 
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
            localbdm.ZNW = ((bgh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259052);
          return 0;
        case 2: 
          localbdm.msg_type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259052);
          return 0;
        case 3: 
          localbdm.Tro = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259052);
          return 0;
        case 4: 
          localbdm.ZNX = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259052);
          return 0;
        case 5: 
          localbdm.ZNY = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259052);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ben();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ben)localObject2).parseFrom((byte[])localObject1);
            }
            localbdm.ZNZ = ((ben)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259052);
          return 0;
        case 7: 
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
            localbdm.ZOa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259052);
          return 0;
        case 51: 
          localbdm.session_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259052);
          return 0;
        case 52: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfv)localObject2).parseFrom((byte[])localObject1);
            }
            localbdm.akjQ = ((bfv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259052);
          return 0;
        case 101: 
          localbdm.seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259052);
          return 0;
        case 102: 
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
            localbdm.ZOb = ((bgh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259052);
          return 0;
        case 103: 
          localbdm.ZOc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259052);
          return 0;
        }
        localbdm.ZOd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259052);
        return 0;
      }
      AppMethodBeat.o(259052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdm
 * JD-Core Version:    0.7.0.1
 */