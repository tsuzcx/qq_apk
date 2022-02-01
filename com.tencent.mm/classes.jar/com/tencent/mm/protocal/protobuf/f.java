package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends dop
{
  public String KBA;
  public String KBB;
  public String KBC;
  public String KBt;
  public int KBv;
  public long KBw;
  public LinkedList<String> KBx;
  public bf KBy;
  public long KBz;
  public int scene;
  public String title;
  
  public f()
  {
    AppMethodBeat.i(91315);
    this.KBx = new LinkedList();
    AppMethodBeat.o(91315);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91316);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KBv);
      paramVarArgs.bb(3, this.KBw);
      if (this.title != null) {
        paramVarArgs.e(4, this.title);
      }
      paramVarArgs.e(5, 1, this.KBx);
      paramVarArgs.aM(6, this.scene);
      if (this.KBt != null) {
        paramVarArgs.e(7, this.KBt);
      }
      if (this.KBy != null)
      {
        paramVarArgs.ni(8, this.KBy.computeSize());
        this.KBy.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(9, this.KBz);
      if (this.KBA != null) {
        paramVarArgs.e(10, this.KBA);
      }
      if (this.KBB != null) {
        paramVarArgs.e(11, this.KBB);
      }
      if (this.KBC != null) {
        paramVarArgs.e(12, this.KBC);
      }
      AppMethodBeat.o(91316);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KBv) + g.a.a.b.b.a.r(3, this.KBw);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.title);
      }
      i = paramInt + g.a.a.a.c(5, 1, this.KBx) + g.a.a.b.b.a.bu(6, this.scene);
      paramInt = i;
      if (this.KBt != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KBt);
      }
      i = paramInt;
      if (this.KBy != null) {
        i = paramInt + g.a.a.a.nh(8, this.KBy.computeSize());
      }
      i += g.a.a.b.b.a.r(9, this.KBz);
      paramInt = i;
      if (this.KBA != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KBA);
      }
      i = paramInt;
      if (this.KBB != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.KBB);
      }
      paramInt = i;
      if (this.KBC != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KBC);
      }
      AppMethodBeat.o(91316);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KBx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91316);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91316);
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
            localf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 2: 
          localf.KBv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91316);
          return 0;
        case 3: 
          localf.KBw = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91316);
          return 0;
        case 4: 
          localf.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 5: 
          localf.KBx.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(91316);
          return 0;
        case 6: 
          localf.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91316);
          return 0;
        case 7: 
          localf.KBt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localf.KBy = ((bf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 9: 
          localf.KBz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91316);
          return 0;
        case 10: 
          localf.KBA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 11: 
          localf.KBB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91316);
          return 0;
        }
        localf.KBC = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91316);
        return 0;
      }
      AppMethodBeat.o(91316);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.f
 * JD-Core Version:    0.7.0.1
 */