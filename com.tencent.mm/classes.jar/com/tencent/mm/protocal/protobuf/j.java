package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class j
  extends dop
{
  public String KBA;
  public String KBB;
  public String KBC;
  public long KBF;
  public String KBt;
  public LinkedList<l> KBx;
  public bf KBy;
  public long KBz;
  public int scene;
  public String title;
  
  public j()
  {
    AppMethodBeat.i(91318);
    this.KBx = new LinkedList();
    AppMethodBeat.o(91318);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91319);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      paramVarArgs.bb(3, this.KBF);
      paramVarArgs.e(5, 8, this.KBx);
      paramVarArgs.aM(7, this.scene);
      if (this.KBt != null) {
        paramVarArgs.e(8, this.KBt);
      }
      if (this.KBy != null)
      {
        paramVarArgs.ni(9, this.KBy.computeSize());
        this.KBy.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(10, this.KBz);
      if (this.KBA != null) {
        paramVarArgs.e(11, this.KBA);
      }
      if (this.KBB != null) {
        paramVarArgs.e(12, this.KBB);
      }
      if (this.KBC != null) {
        paramVarArgs.e(13, this.KBC);
      }
      AppMethodBeat.o(91319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.title);
      }
      i = i + g.a.a.b.b.a.r(3, this.KBF) + g.a.a.a.c(5, 8, this.KBx) + g.a.a.b.b.a.bu(7, this.scene);
      paramInt = i;
      if (this.KBt != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KBt);
      }
      i = paramInt;
      if (this.KBy != null) {
        i = paramInt + g.a.a.a.nh(9, this.KBy.computeSize());
      }
      i += g.a.a.b.b.a.r(10, this.KBz);
      paramInt = i;
      if (this.KBA != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KBA);
      }
      i = paramInt;
      if (this.KBB != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KBB);
      }
      paramInt = i;
      if (this.KBC != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.KBC);
      }
      AppMethodBeat.o(91319);
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
        AppMethodBeat.o(91319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 6: 
        default: 
          AppMethodBeat.o(91319);
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
            localj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 2: 
          localj.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 3: 
          localj.KBF = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91319);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localj.KBx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 7: 
          localj.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91319);
          return 0;
        case 8: 
          localj.KBt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localj.KBy = ((bf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 10: 
          localj.KBz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91319);
          return 0;
        case 11: 
          localj.KBA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 12: 
          localj.KBB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91319);
          return 0;
        }
        localj.KBC = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91319);
        return 0;
      }
      AppMethodBeat.o(91319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.j
 * JD-Core Version:    0.7.0.1
 */