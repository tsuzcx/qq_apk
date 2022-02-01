package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class a
  extends com.tencent.mm.bx.a
{
  public TextStatusExtInfo Tog;
  public boolean Toh = true;
  public long Toi;
  public int Toj;
  public int Tok;
  public int Tol;
  public int Tom;
  public String Ton;
  public int Too;
  public String Top;
  public boolean Toq;
  public boolean Tor;
  public int Tos;
  public String Tot;
  public String Tou;
  public long enterTime;
  public String fileUrl;
  public String mediaPath;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290045);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Tog != null)
      {
        paramVarArgs.qD(1, this.Tog.computeSize());
        this.Tog.writeFields(paramVarArgs);
      }
      if (this.mediaPath != null) {
        paramVarArgs.g(2, this.mediaPath);
      }
      if (this.fileUrl != null) {
        paramVarArgs.g(3, this.fileUrl);
      }
      paramVarArgs.di(4, this.Toh);
      if (this.sessionId != null) {
        paramVarArgs.g(5, this.sessionId);
      }
      paramVarArgs.bv(6, this.Toi);
      paramVarArgs.bv(7, this.enterTime);
      paramVarArgs.bS(8, this.Toj);
      paramVarArgs.bS(9, this.Tok);
      paramVarArgs.bS(10, this.Tol);
      paramVarArgs.bS(11, this.Tom);
      if (this.Ton != null) {
        paramVarArgs.g(12, this.Ton);
      }
      paramVarArgs.bS(13, this.Too);
      if (this.Top != null) {
        paramVarArgs.g(14, this.Top);
      }
      paramVarArgs.di(15, this.Toq);
      paramVarArgs.di(16, this.Tor);
      paramVarArgs.bS(17, this.Tos);
      if (this.Tot != null) {
        paramVarArgs.g(18, this.Tot);
      }
      if (this.Tou != null) {
        paramVarArgs.g(19, this.Tou);
      }
      AppMethodBeat.o(290045);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tog == null) {
        break label1196;
      }
    }
    label1196:
    for (int i = i.a.a.a.qC(1, this.Tog.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mediaPath != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mediaPath);
      }
      i = paramInt;
      if (this.fileUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.fileUrl);
      }
      i += i.a.a.b.b.a.ko(4) + 1;
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.sessionId);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.Toi) + i.a.a.b.b.a.q(7, this.enterTime) + i.a.a.b.b.a.cJ(8, this.Toj) + i.a.a.b.b.a.cJ(9, this.Tok) + i.a.a.b.b.a.cJ(10, this.Tol) + i.a.a.b.b.a.cJ(11, this.Tom);
      paramInt = i;
      if (this.Ton != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Ton);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.Too);
      paramInt = i;
      if (this.Top != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.Top);
      }
      i = paramInt + (i.a.a.b.b.a.ko(15) + 1) + (i.a.a.b.b.a.ko(16) + 1) + i.a.a.b.b.a.cJ(17, this.Tos);
      paramInt = i;
      if (this.Tot != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.Tot);
      }
      i = paramInt;
      if (this.Tou != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.Tou);
      }
      AppMethodBeat.o(290045);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290045);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(290045);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            TextStatusExtInfo localTextStatusExtInfo = new TextStatusExtInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localTextStatusExtInfo.parseFrom((byte[])localObject);
            }
            locala.Tog = localTextStatusExtInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(290045);
          return 0;
        case 2: 
          locala.mediaPath = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290045);
          return 0;
        case 3: 
          locala.fileUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290045);
          return 0;
        case 4: 
          locala.Toh = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(290045);
          return 0;
        case 5: 
          locala.sessionId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290045);
          return 0;
        case 6: 
          locala.Toi = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(290045);
          return 0;
        case 7: 
          locala.enterTime = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(290045);
          return 0;
        case 8: 
          locala.Toj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(290045);
          return 0;
        case 9: 
          locala.Tok = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(290045);
          return 0;
        case 10: 
          locala.Tol = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(290045);
          return 0;
        case 11: 
          locala.Tom = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(290045);
          return 0;
        case 12: 
          locala.Ton = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290045);
          return 0;
        case 13: 
          locala.Too = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(290045);
          return 0;
        case 14: 
          locala.Top = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290045);
          return 0;
        case 15: 
          locala.Toq = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(290045);
          return 0;
        case 16: 
          locala.Tor = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(290045);
          return 0;
        case 17: 
          locala.Tos = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(290045);
          return 0;
        case 18: 
          locala.Tot = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(290045);
          return 0;
        }
        locala.Tou = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(290045);
        return 0;
      }
      AppMethodBeat.o(290045);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.a
 * JD-Core Version:    0.7.0.1
 */