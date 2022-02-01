package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bke
  extends com.tencent.mm.bx.a
{
  public bgh EbJ;
  public int GWs;
  public b JaK;
  public int ZOd;
  public String ZTp;
  public bgh ZTq;
  public String content;
  public String headUrl;
  public String kLn;
  public String nickname;
  public long seq;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259640);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.g(1, this.nickname);
      }
      if (this.headUrl != null) {
        paramVarArgs.g(2, this.headUrl);
      }
      if (this.content != null) {
        paramVarArgs.g(3, this.content);
      }
      paramVarArgs.bS(4, this.type);
      if (this.username != null) {
        paramVarArgs.g(5, this.username);
      }
      paramVarArgs.bv(6, this.seq);
      if (this.kLn != null) {
        paramVarArgs.g(7, this.kLn);
      }
      paramVarArgs.bS(8, this.GWs);
      if (this.EbJ != null)
      {
        paramVarArgs.qD(9, this.EbJ.computeSize());
        this.EbJ.writeFields(paramVarArgs);
      }
      if (this.ZTp != null) {
        paramVarArgs.g(10, this.ZTp);
      }
      if (this.JaK != null) {
        paramVarArgs.d(11, this.JaK);
      }
      if (this.ZTq != null)
      {
        paramVarArgs.qD(12, this.ZTq.computeSize());
        this.ZTq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(1000, this.ZOd);
      AppMethodBeat.o(259640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label1078;
      }
    }
    label1078:
    for (int i = i.a.a.b.b.a.h(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.headUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.headUrl);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.content);
      }
      i += i.a.a.b.b.a.cJ(4, this.type);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.username);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.seq);
      paramInt = i;
      if (this.kLn != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.kLn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.GWs);
      paramInt = i;
      if (this.EbJ != null) {
        paramInt = i + i.a.a.a.qC(9, this.EbJ.computeSize());
      }
      i = paramInt;
      if (this.ZTp != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ZTp);
      }
      paramInt = i;
      if (this.JaK != null) {
        paramInt = i + i.a.a.b.b.a.c(11, this.JaK);
      }
      i = paramInt;
      if (this.ZTq != null) {
        i = paramInt + i.a.a.a.qC(12, this.ZTq.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(1000, this.ZOd);
      AppMethodBeat.o(259640);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259640);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bke localbke = (bke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        bgh localbgh;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259640);
          return -1;
        case 1: 
          localbke.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259640);
          return 0;
        case 2: 
          localbke.headUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259640);
          return 0;
        case 3: 
          localbke.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259640);
          return 0;
        case 4: 
          localbke.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259640);
          return 0;
        case 5: 
          localbke.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259640);
          return 0;
        case 6: 
          localbke.seq = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259640);
          return 0;
        case 7: 
          localbke.kLn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259640);
          return 0;
        case 8: 
          localbke.GWs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259640);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbgh = new bgh();
            if ((localObject != null) && (localObject.length > 0)) {
              localbgh.parseFrom((byte[])localObject);
            }
            localbke.EbJ = localbgh;
            paramInt += 1;
          }
          AppMethodBeat.o(259640);
          return 0;
        case 10: 
          localbke.ZTp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259640);
          return 0;
        case 11: 
          localbke.JaK = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259640);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbgh = new bgh();
            if ((localObject != null) && (localObject.length > 0)) {
              localbgh.parseFrom((byte[])localObject);
            }
            localbke.ZTq = localbgh;
            paramInt += 1;
          }
          AppMethodBeat.o(259640);
          return 0;
        }
        localbke.ZOd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259640);
        return 0;
      }
      AppMethodBeat.o(259640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bke
 * JD-Core Version:    0.7.0.1
 */