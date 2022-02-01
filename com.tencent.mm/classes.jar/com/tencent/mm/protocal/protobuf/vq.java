package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vq
  extends dyl
{
  public String ImG;
  public String ImH;
  public String ImY;
  public String Imv;
  public String Inb;
  public String ShQ;
  public int amount;
  public String nickname;
  public String tsk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91400);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.amount);
      if (this.tsk != null) {
        paramVarArgs.f(3, this.tsk);
      }
      if (this.ImY != null) {
        paramVarArgs.f(4, this.ImY);
      }
      if (this.ShQ != null) {
        paramVarArgs.f(5, this.ShQ);
      }
      if (this.ImG != null) {
        paramVarArgs.f(6, this.ImG);
      }
      if (this.ImH != null) {
        paramVarArgs.f(7, this.ImH);
      }
      if (this.Inb != null) {
        paramVarArgs.f(8, this.Inb);
      }
      if (this.nickname != null) {
        paramVarArgs.f(9, this.nickname);
      }
      if (this.Imv != null) {
        paramVarArgs.f(10, this.Imv);
      }
      AppMethodBeat.o(91400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label824;
      }
    }
    label824:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.amount);
      paramInt = i;
      if (this.tsk != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tsk);
      }
      i = paramInt;
      if (this.ImY != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ImY);
      }
      paramInt = i;
      if (this.ShQ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ShQ);
      }
      i = paramInt;
      if (this.ImG != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ImG);
      }
      paramInt = i;
      if (this.ImH != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ImH);
      }
      i = paramInt;
      if (this.Inb != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Inb);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.nickname);
      }
      i = paramInt;
      if (this.Imv != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Imv);
      }
      AppMethodBeat.o(91400);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        vq localvq = (vq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91400);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localvq.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91400);
          return 0;
        case 2: 
          localvq.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91400);
          return 0;
        case 3: 
          localvq.tsk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 4: 
          localvq.ImY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 5: 
          localvq.ShQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 6: 
          localvq.ImG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 7: 
          localvq.ImH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 8: 
          localvq.Inb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91400);
          return 0;
        case 9: 
          localvq.nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91400);
          return 0;
        }
        localvq.Imv = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91400);
        return 0;
      }
      AppMethodBeat.o(91400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vq
 * JD-Core Version:    0.7.0.1
 */