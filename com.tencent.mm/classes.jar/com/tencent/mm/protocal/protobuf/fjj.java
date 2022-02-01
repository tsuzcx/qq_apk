package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fjj
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String Id;
  public String UserName;
  public enw abJY;
  public fij abJZ;
  public String abKa;
  public int abKb;
  public int abKc;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118475);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.g(1, this.Id);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      paramVarArgs.bS(3, this.CreateTime);
      if (this.abJY != null)
      {
        paramVarArgs.qD(4, this.abJY.computeSize());
        this.abJY.writeFields(paramVarArgs);
      }
      if (this.abJZ != null)
      {
        paramVarArgs.qD(5, this.abJZ.computeSize());
        this.abJZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.timeStamp);
      if (this.abKa != null) {
        paramVarArgs.g(7, this.abKa);
      }
      paramVarArgs.bS(8, this.abKb);
      paramVarArgs.bS(9, this.abKc);
      AppMethodBeat.o(118475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = i.a.a.b.b.a.h(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.UserName);
      }
      i += i.a.a.b.b.a.cJ(3, this.CreateTime);
      paramInt = i;
      if (this.abJY != null) {
        paramInt = i + i.a.a.a.qC(4, this.abJY.computeSize());
      }
      i = paramInt;
      if (this.abJZ != null) {
        i = paramInt + i.a.a.a.qC(5, this.abJZ.computeSize());
      }
      i += i.a.a.b.b.a.q(6, this.timeStamp);
      paramInt = i;
      if (this.abKa != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abKa);
      }
      i = i.a.a.b.b.a.cJ(8, this.abKb);
      int j = i.a.a.b.b.a.cJ(9, this.abKc);
      AppMethodBeat.o(118475);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fjj localfjj = (fjj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118475);
          return -1;
        case 1: 
          localfjj.Id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 2: 
          localfjj.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 3: 
          localfjj.CreateTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118475);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enw)localObject2).parseFrom((byte[])localObject1);
            }
            localfjj.abJY = ((enw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fij();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fij)localObject2).parseFrom((byte[])localObject1);
            }
            localfjj.abJZ = ((fij)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 6: 
          localfjj.timeStamp = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(118475);
          return 0;
        case 7: 
          localfjj.abKa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 8: 
          localfjj.abKb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118475);
          return 0;
        }
        localfjj.abKc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118475);
        return 0;
      }
      AppMethodBeat.o(118475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjj
 * JD-Core Version:    0.7.0.1
 */