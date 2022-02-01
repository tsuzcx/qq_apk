package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends dop
{
  public String KBA;
  public String KBB;
  public String KBC;
  public String KBt;
  public bf KBy;
  public long KBz;
  public int scene;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200185);
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
      paramVarArgs.aM(3, this.scene);
      if (this.KBt != null) {
        paramVarArgs.e(4, this.KBt);
      }
      if (this.KBy != null)
      {
        paramVarArgs.ni(5, this.KBy.computeSize());
        this.KBy.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.KBz);
      if (this.KBA != null) {
        paramVarArgs.e(7, this.KBA);
      }
      if (this.KBB != null) {
        paramVarArgs.e(8, this.KBB);
      }
      if (this.KBC != null) {
        paramVarArgs.e(9, this.KBC);
      }
      AppMethodBeat.o(200185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.title);
      }
      i += g.a.a.b.b.a.bu(3, this.scene);
      paramInt = i;
      if (this.KBt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KBt);
      }
      i = paramInt;
      if (this.KBy != null) {
        i = paramInt + g.a.a.a.nh(5, this.KBy.computeSize());
      }
      i += g.a.a.b.b.a.r(6, this.KBz);
      paramInt = i;
      if (this.KBA != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KBA);
      }
      i = paramInt;
      if (this.KBB != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KBB);
      }
      paramInt = i;
      if (this.KBC != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KBC);
      }
      AppMethodBeat.o(200185);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200185);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200185);
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
            localh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200185);
          return 0;
        case 2: 
          localh.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200185);
          return 0;
        case 3: 
          localh.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(200185);
          return 0;
        case 4: 
          localh.KBt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200185);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localh.KBy = ((bf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200185);
          return 0;
        case 6: 
          localh.KBz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(200185);
          return 0;
        case 7: 
          localh.KBA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200185);
          return 0;
        case 8: 
          localh.KBB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200185);
          return 0;
        }
        localh.KBC = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(200185);
        return 0;
      }
      AppMethodBeat.o(200185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.h
 * JD-Core Version:    0.7.0.1
 */