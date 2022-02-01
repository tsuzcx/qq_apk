package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class csb
  extends dpc
{
  public baw LAF;
  public b LBu;
  public awu LDS;
  public b LDs;
  public bcx LEA;
  public LinkedList<bcu> LEy;
  public LinkedList<bdb> LEz;
  public String Mxi;
  public LinkedList<FinderObject> object;
  public String request_id;
  public int tUC;
  
  public csb()
  {
    AppMethodBeat.i(256714);
    this.object = new LinkedList();
    this.LEy = new LinkedList();
    this.LEz = new LinkedList();
    AppMethodBeat.o(256714);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256715);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.LDs != null) {
        paramVarArgs.c(3, this.LDs);
      }
      paramVarArgs.aM(4, this.tUC);
      if (this.LBu != null) {
        paramVarArgs.c(5, this.LBu);
      }
      if (this.LAF != null)
      {
        paramVarArgs.ni(6, this.LAF.computeSize());
        this.LAF.writeFields(paramVarArgs);
      }
      if (this.Mxi != null) {
        paramVarArgs.e(7, this.Mxi);
      }
      paramVarArgs.e(8, 8, this.LEy);
      paramVarArgs.e(9, 8, this.LEz);
      if (this.LDS != null)
      {
        paramVarArgs.ni(10, this.LDS.computeSize());
        this.LDS.writeFields(paramVarArgs);
      }
      if (this.LEA != null)
      {
        paramVarArgs.ni(11, this.LEA.computeSize());
        this.LEA.writeFields(paramVarArgs);
      }
      if (this.request_id != null) {
        paramVarArgs.e(100, this.request_id);
      }
      AppMethodBeat.o(256715);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1530;
      }
    }
    label1530:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.LDs != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.LDs);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.tUC);
      paramInt = i;
      if (this.LBu != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.LBu);
      }
      i = paramInt;
      if (this.LAF != null) {
        i = paramInt + g.a.a.a.nh(6, this.LAF.computeSize());
      }
      paramInt = i;
      if (this.Mxi != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Mxi);
      }
      i = paramInt + g.a.a.a.c(8, 8, this.LEy) + g.a.a.a.c(9, 8, this.LEz);
      paramInt = i;
      if (this.LDS != null) {
        paramInt = i + g.a.a.a.nh(10, this.LDS.computeSize());
      }
      i = paramInt;
      if (this.LEA != null) {
        i = paramInt + g.a.a.a.nh(11, this.LEA.computeSize());
      }
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + g.a.a.b.b.a.f(100, this.request_id);
      }
      AppMethodBeat.o(256715);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.LEy.clear();
        this.LEz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256715);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csb localcsb = (csb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256715);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256715);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsb.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256715);
          return 0;
        case 3: 
          localcsb.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(256715);
          return 0;
        case 4: 
          localcsb.tUC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256715);
          return 0;
        case 5: 
          localcsb.LBu = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(256715);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new baw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((baw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsb.LAF = ((baw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256715);
          return 0;
        case 7: 
          localcsb.Mxi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256715);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsb.LEy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256715);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsb.LEz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256715);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsb.LDS = ((awu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256715);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsb.LEA = ((bcx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256715);
          return 0;
        }
        localcsb.request_id = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256715);
        return 0;
      }
      AppMethodBeat.o(256715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csb
 * JD-Core Version:    0.7.0.1
 */