package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqj
  extends com.tencent.mm.cd.a
{
  public aed TXc;
  public cxo TXe;
  public String jump_url;
  public int type;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(253334);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      paramVarArgs.aY(2, this.type);
      if (this.jump_url != null) {
        paramVarArgs.f(3, this.jump_url);
      }
      if (this.TXe != null)
      {
        paramVarArgs.oE(4, this.TXe.computeSize());
        this.TXe.writeFields(paramVarArgs);
      }
      if (this.TXc != null)
      {
        paramVarArgs.oE(5, this.TXc.computeSize());
        this.TXc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(253334);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = g.a.a.b.b.a.g(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.jump_url);
      }
      i = paramInt;
      if (this.TXe != null) {
        i = paramInt + g.a.a.a.oD(4, this.TXe.computeSize());
      }
      paramInt = i;
      if (this.TXc != null) {
        paramInt = i + g.a.a.a.oD(5, this.TXc.computeSize());
      }
      AppMethodBeat.o(253334);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(253334);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dqj localdqj = (dqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(253334);
          return -1;
        case 1: 
          localdqj.wording = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(253334);
          return 0;
        case 2: 
          localdqj.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(253334);
          return 0;
        case 3: 
          localdqj.jump_url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(253334);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxo)localObject2).parseFrom((byte[])localObject1);
            }
            localdqj.TXe = ((cxo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(253334);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aed();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aed)localObject2).parseFrom((byte[])localObject1);
          }
          localdqj.TXc = ((aed)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(253334);
        return 0;
      }
      AppMethodBeat.o(253334);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqj
 * JD-Core Version:    0.7.0.1
 */