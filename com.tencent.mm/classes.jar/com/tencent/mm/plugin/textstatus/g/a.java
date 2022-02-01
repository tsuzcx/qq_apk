package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class a
  extends com.tencent.mm.bw.a
{
  public String FZB;
  public String Gae;
  public boolean Gaf;
  public int Gag;
  public String Gah;
  public String Gai;
  public String Gaj;
  public LinkedList<r> Gak;
  public long UrT;
  public String brandName;
  public String desc;
  public long enterTime;
  public String fileUrl;
  public String fuN;
  public String iFo;
  public String jhb;
  public int mediaType;
  public String sessionId;
  public String thumbUrl;
  
  public a()
  {
    AppMethodBeat.i(222817);
    this.Gak = new LinkedList();
    AppMethodBeat.o(222817);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222818);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Gae != null) {
        paramVarArgs.e(1, this.Gae);
      }
      if (this.FZB != null) {
        paramVarArgs.e(2, this.FZB);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.e(4, this.thumbUrl);
      }
      if (this.fileUrl != null) {
        paramVarArgs.e(5, this.fileUrl);
      }
      if (this.jhb != null) {
        paramVarArgs.e(6, this.jhb);
      }
      if (this.brandName != null) {
        paramVarArgs.e(7, this.brandName);
      }
      paramVarArgs.cc(8, this.Gaf);
      paramVarArgs.aM(9, this.mediaType);
      paramVarArgs.aM(10, this.Gag);
      if (this.Gah != null) {
        paramVarArgs.e(11, this.Gah);
      }
      if (this.Gai != null) {
        paramVarArgs.e(12, this.Gai);
      }
      if (this.fuN != null) {
        paramVarArgs.e(13, this.fuN);
      }
      if (this.iFo != null) {
        paramVarArgs.e(14, this.iFo);
      }
      if (this.Gaj != null) {
        paramVarArgs.e(15, this.Gaj);
      }
      paramVarArgs.e(16, 8, this.Gak);
      if (this.sessionId != null) {
        paramVarArgs.e(17, this.sessionId);
      }
      paramVarArgs.bb(18, this.UrT);
      paramVarArgs.bb(19, this.enterTime);
      AppMethodBeat.o(222818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gae == null) {
        break label1322;
      }
    }
    label1322:
    for (int i = g.a.a.b.b.a.f(1, this.Gae) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FZB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.FZB);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.desc);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.fileUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.fileUrl);
      }
      paramInt = i;
      if (this.jhb != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.jhb);
      }
      i = paramInt;
      if (this.brandName != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.brandName);
      }
      i = i + (g.a.a.b.b.a.fS(8) + 1) + g.a.a.b.b.a.bu(9, this.mediaType) + g.a.a.b.b.a.bu(10, this.Gag);
      paramInt = i;
      if (this.Gah != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Gah);
      }
      i = paramInt;
      if (this.Gai != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Gai);
      }
      paramInt = i;
      if (this.fuN != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.fuN);
      }
      i = paramInt;
      if (this.iFo != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.iFo);
      }
      paramInt = i;
      if (this.Gaj != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Gaj);
      }
      i = paramInt + g.a.a.a.c(16, 8, this.Gak);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.sessionId);
      }
      i = g.a.a.b.b.a.r(18, this.UrT);
      int j = g.a.a.b.b.a.r(19, this.enterTime);
      AppMethodBeat.o(222818);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gak.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(222818);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(222818);
          return -1;
        case 1: 
          locala.Gae = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 2: 
          locala.FZB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 3: 
          locala.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 4: 
          locala.thumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 5: 
          locala.fileUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 6: 
          locala.jhb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 7: 
          locala.brandName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 8: 
          locala.Gaf = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(222818);
          return 0;
        case 9: 
          locala.mediaType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(222818);
          return 0;
        case 10: 
          locala.Gag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(222818);
          return 0;
        case 11: 
          locala.Gah = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 12: 
          locala.Gai = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 13: 
          locala.fuN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 14: 
          locala.iFo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 15: 
          locala.Gaj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locala.Gak.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(222818);
          return 0;
        case 17: 
          locala.sessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(222818);
          return 0;
        case 18: 
          locala.UrT = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(222818);
          return 0;
        }
        locala.enterTime = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(222818);
        return 0;
      }
      AppMethodBeat.o(222818);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.a
 * JD-Core Version:    0.7.0.1
 */