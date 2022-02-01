package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class tv
  extends com.tencent.mm.bx.a
{
  public String YFh;
  public b YZA;
  public tw YZB;
  public tu YZC;
  public tx YZD;
  public tt YZE;
  public String YZz;
  public String cli_msg_id;
  public String from_username;
  public int msg_type;
  public String waL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259749);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.msg_type);
      if (this.from_username != null) {
        paramVarArgs.g(2, this.from_username);
      }
      if (this.waL != null) {
        paramVarArgs.g(3, this.waL);
      }
      if (this.cli_msg_id != null) {
        paramVarArgs.g(4, this.cli_msg_id);
      }
      if (this.YZz != null) {
        paramVarArgs.g(5, this.YZz);
      }
      if (this.YZA != null) {
        paramVarArgs.d(6, this.YZA);
      }
      if (this.YFh != null) {
        paramVarArgs.g(7, this.YFh);
      }
      if (this.YZB != null)
      {
        paramVarArgs.qD(101, this.YZB.computeSize());
        this.YZB.writeFields(paramVarArgs);
      }
      if (this.YZC != null)
      {
        paramVarArgs.qD(102, this.YZC.computeSize());
        this.YZC.writeFields(paramVarArgs);
      }
      if (this.YZD != null)
      {
        paramVarArgs.qD(103, this.YZD.computeSize());
        this.YZD.writeFields(paramVarArgs);
      }
      if (this.YZE != null)
      {
        paramVarArgs.qD(107, this.YZE.computeSize());
        this.YZE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259749);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.msg_type) + 0;
      paramInt = i;
      if (this.from_username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.from_username);
      }
      i = paramInt;
      if (this.waL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.waL);
      }
      paramInt = i;
      if (this.cli_msg_id != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.cli_msg_id);
      }
      i = paramInt;
      if (this.YZz != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YZz);
      }
      paramInt = i;
      if (this.YZA != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.YZA);
      }
      i = paramInt;
      if (this.YFh != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YFh);
      }
      paramInt = i;
      if (this.YZB != null) {
        paramInt = i + i.a.a.a.qC(101, this.YZB.computeSize());
      }
      i = paramInt;
      if (this.YZC != null) {
        i = paramInt + i.a.a.a.qC(102, this.YZC.computeSize());
      }
      paramInt = i;
      if (this.YZD != null) {
        paramInt = i + i.a.a.a.qC(103, this.YZD.computeSize());
      }
      i = paramInt;
      if (this.YZE != null) {
        i = paramInt + i.a.a.a.qC(107, this.YZE.computeSize());
      }
      AppMethodBeat.o(259749);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259749);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      tv localtv = (tv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259749);
        return -1;
      case 1: 
        localtv.msg_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259749);
        return 0;
      case 2: 
        localtv.from_username = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259749);
        return 0;
      case 3: 
        localtv.waL = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259749);
        return 0;
      case 4: 
        localtv.cli_msg_id = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259749);
        return 0;
      case 5: 
        localtv.YZz = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259749);
        return 0;
      case 6: 
        localtv.YZA = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(259749);
        return 0;
      case 7: 
        localtv.YFh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259749);
        return 0;
      case 101: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new tw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((tw)localObject2).parseFrom((byte[])localObject1);
          }
          localtv.YZB = ((tw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259749);
        return 0;
      case 102: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new tu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((tu)localObject2).parseFrom((byte[])localObject1);
          }
          localtv.YZC = ((tu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259749);
        return 0;
      case 103: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new tx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((tx)localObject2).parseFrom((byte[])localObject1);
          }
          localtv.YZD = ((tx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259749);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new tt();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((tt)localObject2).parseFrom((byte[])localObject1);
        }
        localtv.YZE = ((tt)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259749);
      return 0;
    }
    AppMethodBeat.o(259749);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tv
 * JD-Core Version:    0.7.0.1
 */