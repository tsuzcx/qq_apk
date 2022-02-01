package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fjg
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String IMg;
  public String IMh;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public int abDg;
  public int abDh;
  public String abIW;
  public String abIX;
  public int abIZ;
  public fiz abJh;
  public String nUB;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118472);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Id);
      if (this.IMh != null) {
        paramVarArgs.g(2, this.IMh);
      }
      if (this.IMg != null) {
        paramVarArgs.g(3, this.IMg);
      }
      if (this.abIW != null) {
        paramVarArgs.g(4, this.abIW);
      }
      if (this.abIX != null) {
        paramVarArgs.g(5, this.abIX);
      }
      if (this.nUB != null) {
        paramVarArgs.g(6, this.nUB);
      }
      paramVarArgs.bS(7, this.vhJ);
      paramVarArgs.bS(8, this.CreateTime);
      paramVarArgs.bS(9, this.abDh);
      paramVarArgs.bS(10, this.abDg);
      paramVarArgs.bS(11, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.g(12, this.ThumbUrl);
      }
      if (this.abJh != null)
      {
        paramVarArgs.qD(13, this.abJh.computeSize());
        this.abJh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.abIZ);
      AppMethodBeat.o(118472);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.IMh != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IMh);
      }
      i = paramInt;
      if (this.IMg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IMg);
      }
      paramInt = i;
      if (this.abIW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abIW);
      }
      i = paramInt;
      if (this.abIX != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abIX);
      }
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.nUB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.vhJ) + i.a.a.b.b.a.cJ(8, this.CreateTime) + i.a.a.b.b.a.cJ(9, this.abDh) + i.a.a.b.b.a.cJ(10, this.abDg) + i.a.a.b.b.a.cJ(11, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ThumbUrl);
      }
      i = paramInt;
      if (this.abJh != null) {
        i = paramInt + i.a.a.a.qC(13, this.abJh.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(14, this.abIZ);
      AppMethodBeat.o(118472);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(118472);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fjg localfjg = (fjg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118472);
        return -1;
      case 1: 
        localfjg.Id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(118472);
        return 0;
      case 2: 
        localfjg.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 3: 
        localfjg.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 4: 
        localfjg.abIW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 5: 
        localfjg.abIX = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 6: 
        localfjg.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 7: 
        localfjg.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118472);
        return 0;
      case 8: 
        localfjg.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118472);
        return 0;
      case 9: 
        localfjg.abDh = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118472);
        return 0;
      case 10: 
        localfjg.abDg = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118472);
        return 0;
      case 11: 
        localfjg.IsNotRichText = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118472);
        return 0;
      case 12: 
        localfjg.ThumbUrl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 13: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fiz localfiz = new fiz();
          if ((localObject != null) && (localObject.length > 0)) {
            localfiz.parseFrom((byte[])localObject);
          }
          localfjg.abJh = localfiz;
          paramInt += 1;
        }
        AppMethodBeat.o(118472);
        return 0;
      }
      localfjg.abIZ = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(118472);
      return 0;
    }
    AppMethodBeat.o(118472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjg
 * JD-Core Version:    0.7.0.1
 */