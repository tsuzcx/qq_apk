package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eem
  extends com.tencent.mm.bx.a
{
  public String abjO;
  public String abjP;
  public LinkedList<Integer> abjQ;
  public LinkedList<Integer> abjR;
  public String abjS;
  public boolean abjT;
  public LinkedList<fms> abjk;
  
  public eem()
  {
    AppMethodBeat.i(260000);
    this.abjk = new LinkedList();
    this.abjQ = new LinkedList();
    this.abjR = new LinkedList();
    AppMethodBeat.o(260000);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260005);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abjO != null) {
        paramVarArgs.g(1, this.abjO);
      }
      if (this.abjP != null) {
        paramVarArgs.g(2, this.abjP);
      }
      paramVarArgs.e(3, 8, this.abjk);
      paramVarArgs.e(4, 2, this.abjQ);
      paramVarArgs.e(5, 2, this.abjR);
      if (this.abjS != null) {
        paramVarArgs.g(6, this.abjS);
      }
      paramVarArgs.di(7, this.abjT);
      AppMethodBeat.o(260005);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abjO == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = i.a.a.b.b.a.h(1, this.abjO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abjP != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abjP);
      }
      i = i + i.a.a.a.c(3, 8, this.abjk) + i.a.a.a.c(4, 2, this.abjQ) + i.a.a.a.c(5, 2, this.abjR);
      paramInt = i;
      if (this.abjS != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abjS);
      }
      i = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(260005);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abjk.clear();
        this.abjQ.clear();
        this.abjR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260005);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eem localeem = (eem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260005);
          return -1;
        case 1: 
          localeem.abjO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260005);
          return 0;
        case 2: 
          localeem.abjP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260005);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fms localfms = new fms();
            if ((localObject != null) && (localObject.length > 0)) {
              localfms.parseFrom((byte[])localObject);
            }
            localeem.abjk.add(localfms);
            paramInt += 1;
          }
          AppMethodBeat.o(260005);
          return 0;
        case 4: 
          localeem.abjQ.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(260005);
          return 0;
        case 5: 
          localeem.abjR.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(260005);
          return 0;
        case 6: 
          localeem.abjS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260005);
          return 0;
        }
        localeem.abjT = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(260005);
        return 0;
      }
      AppMethodBeat.o(260005);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eem
 * JD-Core Version:    0.7.0.1
 */