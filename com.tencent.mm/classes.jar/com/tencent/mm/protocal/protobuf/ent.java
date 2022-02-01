package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ent
  extends com.tencent.mm.bx.a
{
  public String MRI;
  public long aaxM;
  public String absk;
  public double absl;
  public LinkedList<wx> absm;
  public String absn;
  public LinkedList<esp> abso;
  public String appid;
  public String nickname;
  public String username;
  
  public ent()
  {
    AppMethodBeat.i(50103);
    this.absm = new LinkedList();
    this.abso = new LinkedList();
    AppMethodBeat.o(50103);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50104);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(3, this.nickname);
      }
      if (this.MRI != null) {
        paramVarArgs.g(4, this.MRI);
      }
      paramVarArgs.bv(5, this.aaxM);
      if (this.absk != null) {
        paramVarArgs.g(6, this.absk);
      }
      paramVarArgs.d(7, this.absl);
      paramVarArgs.e(16, 8, this.absm);
      if (this.absn != null) {
        paramVarArgs.g(17, this.absn);
      }
      paramVarArgs.e(19, 8, this.abso);
      AppMethodBeat.o(50104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label885;
      }
    }
    label885:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nickname);
      }
      paramInt = i;
      if (this.MRI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MRI);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.aaxM);
      paramInt = i;
      if (this.absk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.absk);
      }
      i = paramInt + (i.a.a.b.b.a.ko(7) + 8) + i.a.a.a.c(16, 8, this.absm);
      paramInt = i;
      if (this.absn != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.absn);
      }
      i = i.a.a.a.c(19, 8, this.abso);
      AppMethodBeat.o(50104);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.absm.clear();
        this.abso.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ent localent = (ent)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 18: 
        default: 
          AppMethodBeat.o(50104);
          return -1;
        case 1: 
          localent.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 2: 
          localent.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 3: 
          localent.nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 4: 
          localent.MRI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 5: 
          localent.aaxM = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(50104);
          return 0;
        case 6: 
          localent.absk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 7: 
          localent.absl = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(50104);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wx)localObject2).parseFrom((byte[])localObject1);
            }
            localent.absm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50104);
          return 0;
        case 17: 
          localent.absn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(50104);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new esp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((esp)localObject2).parseFrom((byte[])localObject1);
          }
          localent.abso.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      AppMethodBeat.o(50104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ent
 * JD-Core Version:    0.7.0.1
 */