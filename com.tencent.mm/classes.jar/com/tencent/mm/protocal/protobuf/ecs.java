package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecs
  extends dop
{
  public String KIz;
  public int NcY;
  public int NcZ;
  public LinkedList<ecu> Nda;
  public ecr Ndb;
  public int Ndc;
  public LinkedList<ecr> Ndd;
  public String xNG;
  public String xNH;
  
  public ecs()
  {
    AppMethodBeat.i(152697);
    this.Nda = new LinkedList();
    this.Ndd = new LinkedList();
    AppMethodBeat.o(152697);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152698);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.NcY);
      if (this.xNH != null) {
        paramVarArgs.e(3, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(4, this.xNG);
      }
      if (this.KIz != null) {
        paramVarArgs.e(5, this.KIz);
      }
      paramVarArgs.aM(6, this.NcZ);
      paramVarArgs.e(7, 8, this.Nda);
      if (this.Ndb != null)
      {
        paramVarArgs.ni(8, this.Ndb.computeSize());
        this.Ndb.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.Ndc);
      paramVarArgs.e(10, 8, this.Ndd);
      AppMethodBeat.o(152698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.NcY);
      paramInt = i;
      if (this.xNH != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xNH);
      }
      i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.xNG);
      }
      paramInt = i;
      if (this.KIz != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KIz);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.NcZ) + g.a.a.a.c(7, 8, this.Nda);
      paramInt = i;
      if (this.Ndb != null) {
        paramInt = i + g.a.a.a.nh(8, this.Ndb.computeSize());
      }
      i = g.a.a.b.b.a.bu(9, this.Ndc);
      int j = g.a.a.a.c(10, 8, this.Ndd);
      AppMethodBeat.o(152698);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nda.clear();
        this.Ndd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ecs localecs = (ecs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152698);
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
            localecs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 2: 
          localecs.NcY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152698);
          return 0;
        case 3: 
          localecs.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 4: 
          localecs.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 5: 
          localecs.KIz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 6: 
          localecs.NcZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152698);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localecs.Nda.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localecs.Ndb = ((ecr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 9: 
          localecs.Ndc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152698);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ecr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localecs.Ndd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      AppMethodBeat.o(152698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecs
 * JD-Core Version:    0.7.0.1
 */