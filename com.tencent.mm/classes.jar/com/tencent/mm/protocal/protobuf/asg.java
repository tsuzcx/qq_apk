package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asg
  extends com.tencent.mm.bx.a
{
  public int GkQ;
  public long Gqv;
  public String Gqw;
  public int Gqx;
  public int Gqy;
  public String coverUrl;
  public String dzZ;
  public int followFlag;
  public int friendFollowCount;
  public int sMj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209370);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dzZ != null) {
        paramVarArgs.d(1, this.dzZ);
      }
      paramVarArgs.aY(2, this.Gqv);
      paramVarArgs.aS(3, this.GkQ);
      if (this.Gqw != null) {
        paramVarArgs.d(4, this.Gqw);
      }
      paramVarArgs.aS(5, this.sMj);
      paramVarArgs.aS(6, this.followFlag);
      if (this.coverUrl != null) {
        paramVarArgs.d(7, this.coverUrl);
      }
      paramVarArgs.aS(8, this.friendFollowCount);
      paramVarArgs.aS(9, this.Gqx);
      paramVarArgs.aS(10, this.Gqy);
      AppMethodBeat.o(209370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dzZ == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.dzZ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Gqv) + f.a.a.b.b.a.bz(3, this.GkQ);
      paramInt = i;
      if (this.Gqw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gqw);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.sMj) + f.a.a.b.b.a.bz(6, this.followFlag);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.coverUrl);
      }
      i = f.a.a.b.b.a.bz(8, this.friendFollowCount);
      int j = f.a.a.b.b.a.bz(9, this.Gqx);
      int k = f.a.a.b.b.a.bz(10, this.Gqy);
      AppMethodBeat.o(209370);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209370);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        asg localasg = (asg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209370);
          return -1;
        case 1: 
          localasg.dzZ = locala.NPN.readString();
          AppMethodBeat.o(209370);
          return 0;
        case 2: 
          localasg.Gqv = locala.NPN.zd();
          AppMethodBeat.o(209370);
          return 0;
        case 3: 
          localasg.GkQ = locala.NPN.zc();
          AppMethodBeat.o(209370);
          return 0;
        case 4: 
          localasg.Gqw = locala.NPN.readString();
          AppMethodBeat.o(209370);
          return 0;
        case 5: 
          localasg.sMj = locala.NPN.zc();
          AppMethodBeat.o(209370);
          return 0;
        case 6: 
          localasg.followFlag = locala.NPN.zc();
          AppMethodBeat.o(209370);
          return 0;
        case 7: 
          localasg.coverUrl = locala.NPN.readString();
          AppMethodBeat.o(209370);
          return 0;
        case 8: 
          localasg.friendFollowCount = locala.NPN.zc();
          AppMethodBeat.o(209370);
          return 0;
        case 9: 
          localasg.Gqx = locala.NPN.zc();
          AppMethodBeat.o(209370);
          return 0;
        }
        localasg.Gqy = locala.NPN.zc();
        AppMethodBeat.o(209370);
        return 0;
      }
      AppMethodBeat.o(209370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asg
 * JD-Core Version:    0.7.0.1
 */