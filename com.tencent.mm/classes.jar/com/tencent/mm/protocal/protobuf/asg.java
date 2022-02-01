package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asg
  extends com.tencent.mm.cd.a
{
  public String PND;
  public int SFG;
  public long SFH;
  public String SFI;
  public String SFJ;
  public int SFK;
  public FinderContact contact;
  public String coverImgUrl;
  public String description;
  public long endTime;
  public String eventName;
  public int feedCount;
  public int xEZ;
  public long xdR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199523);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.xdR);
      if (this.contact != null)
      {
        paramVarArgs.oE(2, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.eventName != null) {
        paramVarArgs.f(3, this.eventName);
      }
      if (this.description != null) {
        paramVarArgs.f(4, this.description);
      }
      paramVarArgs.aY(5, this.SFG);
      if (this.coverImgUrl != null) {
        paramVarArgs.f(6, this.coverImgUrl);
      }
      paramVarArgs.bm(7, this.SFH);
      paramVarArgs.aY(8, this.feedCount);
      paramVarArgs.aY(9, this.xEZ);
      if (this.PND != null) {
        paramVarArgs.f(10, this.PND);
      }
      if (this.SFI != null) {
        paramVarArgs.f(11, this.SFI);
      }
      if (this.SFJ != null) {
        paramVarArgs.f(12, this.SFJ);
      }
      paramVarArgs.aY(13, this.SFK);
      paramVarArgs.bm(14, this.endTime);
      AppMethodBeat.o(199523);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.xdR) + 0;
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + g.a.a.a.oD(2, this.contact.computeSize());
      }
      i = paramInt;
      if (this.eventName != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.eventName);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.description);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.SFG);
      paramInt = i;
      if (this.coverImgUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.coverImgUrl);
      }
      i = paramInt + g.a.a.b.b.a.p(7, this.SFH) + g.a.a.b.b.a.bM(8, this.feedCount) + g.a.a.b.b.a.bM(9, this.xEZ);
      paramInt = i;
      if (this.PND != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.PND);
      }
      i = paramInt;
      if (this.SFI != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SFI);
      }
      paramInt = i;
      if (this.SFJ != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SFJ);
      }
      i = g.a.a.b.b.a.bM(13, this.SFK);
      int j = g.a.a.b.b.a.p(14, this.endTime);
      AppMethodBeat.o(199523);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(199523);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      asg localasg = (asg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(199523);
        return -1;
      case 1: 
        localasg.xdR = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(199523);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderContact localFinderContact = new FinderContact();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderContact.parseFrom((byte[])localObject);
          }
          localasg.contact = localFinderContact;
          paramInt += 1;
        }
        AppMethodBeat.o(199523);
        return 0;
      case 3: 
        localasg.eventName = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(199523);
        return 0;
      case 4: 
        localasg.description = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(199523);
        return 0;
      case 5: 
        localasg.SFG = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(199523);
        return 0;
      case 6: 
        localasg.coverImgUrl = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(199523);
        return 0;
      case 7: 
        localasg.SFH = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(199523);
        return 0;
      case 8: 
        localasg.feedCount = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(199523);
        return 0;
      case 9: 
        localasg.xEZ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(199523);
        return 0;
      case 10: 
        localasg.PND = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(199523);
        return 0;
      case 11: 
        localasg.SFI = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(199523);
        return 0;
      case 12: 
        localasg.SFJ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(199523);
        return 0;
      case 13: 
        localasg.SFK = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(199523);
        return 0;
      }
      localasg.endTime = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(199523);
      return 0;
    }
    AppMethodBeat.o(199523);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asg
 * JD-Core Version:    0.7.0.1
 */