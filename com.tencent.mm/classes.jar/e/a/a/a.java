package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public String Dvu;
  public String KgO;
  public String KgP;
  public int KgQ;
  public g KgR;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91738);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.KgO != null) {
        paramVarArgs.d(1, this.KgO);
      }
      if (this.KgP != null) {
        paramVarArgs.d(2, this.KgP);
      }
      paramVarArgs.aR(3, this.KgQ);
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.KgR != null)
      {
        paramVarArgs.kX(5, this.KgR.computeSize());
        this.KgR.writeFields(paramVarArgs);
      }
      if (this.Dvu != null) {
        paramVarArgs.d(6, this.Dvu);
      }
      AppMethodBeat.o(91738);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KgO == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.KgO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KgP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.KgP);
      }
      i += f.a.a.b.b.a.bA(3, this.KgQ);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.KgR != null) {
        i = paramInt + f.a.a.a.kW(5, this.KgR.computeSize());
      }
      paramInt = i;
      if (this.Dvu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dvu);
      }
      AppMethodBeat.o(91738);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91738);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91738);
          return -1;
        case 1: 
          locala.KgO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91738);
          return 0;
        case 2: 
          locala.KgP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91738);
          return 0;
        case 3: 
          locala.KgQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91738);
          return 0;
        case 4: 
          locala.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91738);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.KgR = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91738);
          return 0;
        }
        locala.Dvu = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91738);
        return 0;
      }
      AppMethodBeat.o(91738);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.a
 * JD-Core Version:    0.7.0.1
 */